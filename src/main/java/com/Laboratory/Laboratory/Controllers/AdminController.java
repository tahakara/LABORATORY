package com.Laboratory.Laboratory.Controllers;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Laboratory.Laboratory.Services.*;

import com.Laboratory.Laboratory.Services.Interfaces.*;

import jakarta.persistence.NonUniqueResultException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.Laboratory.Laboratory.Entities.*;
import com.Laboratory.Laboratory.Entities.SafeEntities.*;
import com.Laboratory.Laboratory.Entities.FormEntities.Admin.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Value("${api.domain}")
    private String appDomain;

    @Value("${api.protocol}")
    private String appProtocol;

    private IRedisService redisService;
    private IAuthService authService;
    private IAdminService adminService;
    private ILaborantService laborantService;
    private IReportService reportService;
    private IUserService userService;
    private IPhotoService photoService;
    private IMailService mailService;

    @Autowired
    public AdminController(IRedisService redisService , IAuthService authService, IAdminService adminService, ILaborantService laborantService, IReportService reportService, IUserService userService, IPhotoService photoService, IMailService mailService) {
        this.redisService = redisService;
        this.authService = authService;
        this.adminService = adminService;
        this.laborantService = laborantService;
        this.reportService = reportService;
        this.userService = userService;
        this.photoService = photoService;
        this.mailService = mailService;
    }

    // -----*******************-----
    //          Mappings
    // -----*******************-----

    // -- Admin Login | Complated --
    @PostMapping("/login")
    public ResponseEntity<?> loginPost(@RequestBody AdminLoginPostForm loginForm, HttpServletRequest request, HttpServletResponse response) {

        Admin admin = null;
        Map<String, Object> responseBody = new HashMap<>();
        HttpHeaders responseHeaders = new HttpHeaders();

        if (loginForm.getIsAcceptable()) {
            
            if (loginForm.getIdentificationAndPassword()) {

                admin = this.adminService.getByIdentificationNumberAndPassword(Admin.class, loginForm.getIdentificationNumber(), loginForm.getPassword());                
                responseBody.put("type", "IdentificationCard");
            }
            else if (loginForm.getHospitalIdAndPassword()) {
                admin = this.adminService.getByHospitalIDAndPassword(Admin.class, loginForm.getHospitalId(), loginForm.getPassword());
                responseBody.put("type", "HostipalId");
            }
            else if (loginForm.getEmailAndPassword()) {
                admin = this.adminService.getByEmailAndPassword(Admin.class, loginForm.getEmail(), loginForm.getPassword());
                responseBody.put("type", "Email");
            }

            // Not an Admin
            if (admin == null) {
                responseBody.put("status", "Denied");
                responseBody.put("message", "User Not Found");

                responseHeaders.add("Set-Cookie", String.format("Auth-0=; Max-Age=0"));
                return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(responseHeaders).body(responseBody);
            } 
            // Is an Admin
            else {

                Map<String, Object> authpayload = Map.of(
                    "name", admin.getName(),
                    "surname", admin.getSurname(),
                    "hospitalId", admin.getHospitalId(),
                    "UUID", admin.getUuid()
                );

              
                String authJwtToken = this.authService.generateTokenDay(authpayload, 1);

                String redisKeyName = admin.getUuid();
                
                Boolean redisResoult = this.redisService.setAdminKeyValueDay(redisKeyName, authJwtToken, 1)
                .onErrorReturn(false)
                .block() != null;
                
                if (redisResoult == false) {
                    responseBody.put("status", "Denied");
                    responseBody.put("message", "Tokenization Error");
                    responseHeaders.add("Set-Cookie", String.format("Auth-0=; Max-Age=0"));
                    
                } else {
                    responseBody.put("status", "Ok");
                    responseBody.put("message", "Login Success");
                    responseHeaders.add("Set-Cookie", String.format("Auth-0=%s; Domain=.%s; Path=/; SameSite=None; Max-Age=%s",authJwtToken, this.appDomain, "86400"));
                }
                return ResponseEntity.ok().headers(responseHeaders).body(responseBody);
            }

        }
        
        responseBody.put("status", "Denied");
        responseBody.put("message", "Not Acceaptable Form");
        responseHeaders.add("Set-Cookie", String.format("Auth-0=; Max-Age=0"));
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(responseHeaders).body(responseBody);
        
    }

    // -- Admin Logout | Completed --
    @SuppressWarnings("null")
    public ResponseEntity<?> logoutGet(HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> responseBody = new HashMap<>();
        HttpHeaders responseHeaders = new HttpHeaders();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("Auth-0".equals(cookie.getName())) {

                    Map<String, Object> verifiedJwtToken = this.authService.verifyToken(cookie.getValue());
                    if (!verifiedJwtToken.isEmpty()) {
                        
                        this.redisService.deleteAdminValueByKey(verifiedJwtToken.get("UUID").toString())
                            .onErrorReturn(false)
                            .block();
    
                    }
                    
                    Cookie newCookie = new Cookie("Auth-0", "");
                    newCookie.setMaxAge(1);
                    
                    responseHeaders.add(newCookie.getName(), newCookie.getValue());
                    break;
                }
            }
        }

        responseBody.put("status", "Ok");
        responseBody.put("message", "Logout Success");

        return ResponseEntity.ok().headers(responseHeaders).body(responseBody); 
    }



    // -----*******************-----
    //            Profile
    // -----*******************-----

    // -- Admin Profile | Completed -- 
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(HttpServletRequest request, HttpServletResponse response) {
        Admin admin = null;
        Map<String, Object> responseBody = new HashMap<>();
        HttpHeaders responseHeaders = new HttpHeaders();
        
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("Auth-0".equals(cookie.getName())) {
                Map<String, Object> verifiedJwtToken = this.authService.verifyToken(cookie.getValue());
                if (!verifiedJwtToken.isEmpty()) {
                    admin = this.adminService.getByUUID(Admin.class, verifiedJwtToken.get("UUID").toString());
                    if (admin != null) {
                        responseBody.put("status", "Ok");
                        responseBody.put("message", "Profile Found");
                        responseBody.put("data", admin);
                        return ResponseEntity.ok().headers(responseHeaders).body(responseBody);
                    }
                }
            }
        }
        
        responseHeaders.add("Set-Cookie", String.format("Auth-0=; Max-Age=0"));

        responseBody.put("status", "Denied");
        responseBody.put("message", "Unauthorized Access");
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).headers(responseHeaders).body(responseBody);
    }


    // -- Admin Update Profile | Completed --
    @PutMapping("/profile")
    public ResponseEntity<?> putProfile(HttpServletRequest request, HttpServletResponse response, @RequestBody AdminProfilePutForm form) {
        Admin admin = null;
        Map<String, Object> responseBody = new HashMap<>();
        HttpHeaders responseHeaders = new HttpHeaders();

        try {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if ("Auth-0".equals(cookie.getName())) {
                    Map<String, Object> verifiedJwtToken = this.authService.verifyToken(cookie.getValue());
                    if (!verifiedJwtToken.isEmpty()) {
                        admin = this.adminService.getByUUID(Admin.class, verifiedJwtToken.get("UUID").toString());
                        if (admin != null) {
                            form.setQueryValues();
                            admin.setName(form.getQueryAdminName() != null ? form.getQueryAdminName() : admin.getName());
                            admin.setSurname(form.getQueryAdminSurname() != null ? form.getQueryAdminSurname() : admin.getSurname());
                            admin.setEmail(form.getQueryAdminEmail() != null ? form.getQueryAdminEmail() : admin.getEmail());
                            admin.setPassword(form.getQueryAdminPassword() != null ? form.getQueryAdminPassword() : admin.getPassword());

                            Boolean result = this.adminService.updateAdmin(admin);
                            if (result == true) {
                                responseBody.put("status", "Ok");
                                responseBody.put("message", "Profile Updated");
                                return ResponseEntity.ok().headers(responseHeaders).body(responseBody);
                            }

                            responseBody.put("status", "Error");
                            responseBody.put("message", "Profile Not Updated");
                            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
                        }

                        responseBody.put("status", "Denied");
                        responseBody.put("message", "Profile Admin Not Found");
                        responseHeaders.add("Set-Cookie", String.format("Auth-0=; Max-Age=0"));
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(responseHeaders).body(responseBody);
                    }

                    responseBody.put("status", "Denied");
                    responseBody.put("message", "Unauthorized Access");
                    responseHeaders.add("Set-Cookie", String.format("Auth-0=; Max-Age=0"));
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).headers(responseHeaders).body(responseBody);
                }
            }
            
            responseBody.put("staus", "Denied");
            responseBody.put("message", "Unauthorized Access");
            responseHeaders.add("Set-Cookie", String.format("Auth-0=; Max-Age=0"));
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).headers(responseHeaders).body(responseBody);

        } catch (Exception e) {
            responseBody.put("status", "Error");
            responseBody.put("message", "Profile Not Updated");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
    
    
    

    // -----*******************-----
    //          /Laborants
    // -----*******************-----
    
    // -- Admin Show Laborants | Completed --
    @GetMapping("/laborants")
    public ResponseEntity<?> getLaborants(@RequestBody AdminLaborantGetForms form) {
        Map<String, Object> responseBody = new HashMap<>();
        try {
            form.setQueryValues();
            if (form.getIsAcceptable() != true) {
                responseBody.put("status", "Denied");
                responseBody.put("message", "Not Acceptable Form");
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);
            } 

            if (form.getIsRequestedList()) {
                List<LaborantSafe> laborants;
                if (form.getQueryName()!=null && form.getQuerySurname()!=null && (form.getIsActiveWork() !=null ? form.getIsActiveWork() : false ) && (form.getIsVerified() != null ? form.getIsVerified() : false)) {
                    laborants = this.laborantService.getAllByNameAndSurnameAndVerifiedAndIsActiveWork(LaborantSafe.class, form.getQueryName(), form.getQuerySurname(), form.getIsVerified(), form.getIsActiveWork(), form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
                } else if (form.getQueryName()!=null && form.getQuerySurname()!=null && (form.getIsActiveWork() !=null ? form.getIsActiveWork() : false )) {
                    laborants = this.laborantService.getAllByNameAndSurnameAndIsActiveWork(LaborantSafe.class, form.getQueryName(), form.getQuerySurname(), form.getIsActiveWork(), form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
                } else if (form.getQueryName()!=null && form.getQuerySurname()!=null && (form.getIsVerified() != null ? form.getIsVerified() : false)) {
                    laborants = this.laborantService.getAllByNameAndSurnameAndVerified(LaborantSafe.class, form.getQueryName(), form.getQuerySurname(), form.getQueryIsVerified(), form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
                } else if (form.getQueryName()!=null && form.getQuerySurname()!=null) {
                    laborants = this.laborantService.getAllByNameAndSurname(LaborantSafe.class, form.getQueryName(), form.getQuerySurname(), form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
                } else if ((form.getIsActiveWork() !=null ? form.getIsActiveWork() : false )) {
                    laborants = this.laborantService.getAllByIsActiveWork(LaborantSafe.class, form.getQueryIsActiveWork(), form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
                } else if ((form.getIsVerified() != null ? form.getIsVerified() : false)) {
                    laborants = this.laborantService.getAllByVerified(LaborantSafe.class, form.getQueryIsVerified(), form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
                } else if (form.getQueryName()!= null) {
                    laborants = this.laborantService.getAllByName(LaborantSafe.class, form.getQueryName(), form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
                } else if (form.getQuerySurname()!=null) {
                    laborants = this.laborantService.getAllBySurname(LaborantSafe.class, form.getQuerySurname(), form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
                } else {
                    laborants = this.laborantService.getAll(LaborantSafe.class, form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
                }

                responseBody.put("data", laborants);
                responseBody.put("status", "Ok");
                responseBody.put("message", "Laborants Listed");
                return ResponseEntity.ok(responseBody);

            }
        
            // responseBody.put("data", this.laborantService.getAll(page, 100));
            responseBody.put("status", "Denied");
            responseBody.put("message", "Request Not Acceptable If You Want One Laborant Use /laborant Endpoint");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);
        
        } catch (Exception e) {
            System.err.println(e);
            responseBody.put("status", "Error");
            responseBody.put("message", "Laborants Not Listed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        
        }

    }

    // -- Admin Show Laborant | Completed --
    @GetMapping("/laborant")
    public ResponseEntity<?> getLaborant(@RequestBody AdminLaborantGetForms form) {
        Map<String, Object> responseBody = new HashMap<>();
        try {
            form.setQueryValues();
            if (form.getIsAcceptable() != true) {
                responseBody.put("status", "Denied");
                responseBody.put("message", "Not Acceptable Form");
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);
            }
        
            if (form.getIsRequestedOne()) {
                LaborantSafe laborant = null;
                if (form.getQueryUUID() != null) {
                    laborant = this.laborantService.getByUUID(LaborantSafe.class, form.getUuid());
                } else if (form.getQueryIdentificationNumber() != null) {
                    laborant = this.laborantService.getByIdentificationNumber(LaborantSafe.class, form.getQueryIdentificationNumber());
                } else if (form.getQueryHospitalId() != null) {
                    laborant = this.laborantService.getByHospitalID(LaborantSafe.class, form.getQueryHospitalId());
                } else if (form.getQueryEmail() != null) {
                    laborant = this.laborantService.getByEmail(LaborantSafe.class, form.getQueryEmail());
                } else {
                    responseBody.put("status", "Ok");
                    responseBody.put("message", "Laborant Not Found");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
                }

                if (laborant != null) {
                    responseBody.put("data", laborant);
                    responseBody.put("status", "Ok");
                    responseBody.put("message", "Laborant Found");
                    return ResponseEntity.ok(responseBody);
                }

                responseBody.put("status", "Ok");
                responseBody.put("message", "Laborant Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);

            }

            responseBody.put("status", "Denied");
            responseBody.put("message", "Request Not Acceptable If You Want Multiple Laborant Use /laborants Endpoint");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);
        
        } catch (Exception e) {
            if (e instanceof NonUniqueResultException) {
                responseBody.put("status", "Ok");
                responseBody.put("message", "Laborant Not Found");
                return ResponseEntity.ok(responseBody);
            }
            responseBody.put("status", "Error");
            responseBody.put("message", "Laborant Not Found");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        
        }
    }


    // -- Admin Create New Laborant | Complated --
    @PostMapping("/laborant")
    public ResponseEntity<?> postLaborant(@RequestBody AdminLaborantPostForm form) {
        Map<String, Object> responseBody = new HashMap<>();
        try {
            form.setQueryValues();
            if (form.getIsAcceptable() == true) {

                if (this.laborantService.getByIdentificationNumber(Laborant.class, form.getLaborantIdentificationNumber()) != null) {
                    responseBody.put("status", "Denied");
                    responseBody.put("message", "Identification Number Already Exist");
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);
                }   
                if (this.laborantService.getByHospitalID(Laborant.class, form.getLaborantHospitalID()) != null) {
                    responseBody.put("status", "Denied");
                    responseBody.put("message", "Hospital ID Already Exist");
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);
                }
                if (this.laborantService.getByEmail(Laborant.class, form.getLaborantEmail()) != null) {
                    responseBody.put("status", "Denied");
                    responseBody.put("message", "Email Already Exist");
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);
                }

                Laborant laborant = new Laborant();
                laborant.setName(form.getLaborantName());
                laborant.setSurname(form.getLaborantSurname());
                laborant.setIdentificationNumber(form.getLaborantIdentificationNumber());
                laborant.setHospitalId(form.getLaborantHospitalID());
                laborant.setEmail(form.getLaborantEmail());
                laborant.setIsActiveWork(form.getLaborantIsActiveWork());
                laborant.generateVerificationCode();
                laborant.generateDummyPassword();

                Boolean result = this.laborantService.insertNewLaborant(laborant);

                if (result == true) {
                    String subject = "Laborant Verification";
                    Map<String,Object> contentMap = Map.of(
                        "laborantName", laborant.getName(),
                        "verificationToken", laborant.getVerificationCode(),
                        "senderDepartment", "Laboratory Department"
                    );
                    this.mailService.sendLaborantVerificationMail(laborant.getEmail(), subject, contentMap);

                    responseBody.put("status", "Ok");
                    responseBody.put("message", "Laborant Created");
                    return ResponseEntity.ok(responseBody);
                }

                responseBody.put("status", "Error");
                responseBody.put("message", "Laborant Not Created");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
                

            }

            responseBody.put("status", "Denied");
            responseBody.put("message", "Not Acceptable Form");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);

        } catch (Exception e) {
            responseBody.put("status", "Error");
            responseBody.put("message", "Laborant Not Created");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
    
    // -- Admin Update Laborant | Complated --
    @PutMapping("/laborant")
    public ResponseEntity<?> putLaborant(@RequestBody AdminLaborantPutForm form) {
        Map<String, Object> responseBody = new HashMap<>();
        try {
            form.setQueryValues();
            if (form.getIsAcceptable() == true) {
                Laborant oldLaborant = this.laborantService.getByUUID(Laborant.class, form.getQueryLaborantUUID());

                if (oldLaborant != null) {

                    // write this code with turnary
                    oldLaborant.setName(form.getQueryLaborantName() != null ? form.getQueryLaborantName() : oldLaborant.getName());
                    oldLaborant.setSurname(form.getQueryLaborantSurname() != null ? form.getQueryLaborantSurname() : oldLaborant.getSurname());
                    oldLaborant.setEmail(form.getQueryLaborantEmail() != null ? form.getQueryLaborantEmail() : oldLaborant.getEmail());
                    oldLaborant.setHospitalId(form.getQueryLaborantHospitalId() != null ? form.getQueryLaborantHospitalId() : oldLaborant.getHospitalId());
                    oldLaborant.setIdentificationNumber(form.getQueryLaborantIdentificationNumber() != null ? form.getQueryLaborantIdentificationNumber() : oldLaborant.getIdentificationNumber());
                    oldLaborant.setIsActiveWork(form.getQueryLaborantIsActiveWork() != null ? form.getQueryLaborantIsActiveWork() : oldLaborant.getIsActiveWork());
                    oldLaborant.generateVerificationCode();

                    Laborant newLaborant = oldLaborant;

                    Boolean result = this.laborantService.updateLaborant(newLaborant);
                    if (result == true) {

                        String subject = "Laborant Verification";
                        Map<String,Object> contentMap = Map.of(
                            "laborantName", newLaborant.getName(),
                            "verificationToken", newLaborant.getVerificationCode(),
                            "senderDepartment", "Laboratory Department"
                        );
                        Boolean mailSended =  this.mailService.sendLaborantVerificationMail(newLaborant.getEmail(), subject, contentMap);

                        if (mailSended == true) {
                            responseBody.put("status", "Ok");   
                            responseBody.put("message", "Laborant Updated");
                            return ResponseEntity.ok(responseBody);
                        }

                        responseBody.put("status", "Error");
                        responseBody.put("message", "Laborant Updated Not Verification Mail Not Sended");
                        return ResponseEntity.ok().body(responseBody);
                    }

                    responseBody.put("status", "Error");
                    responseBody.put("message", "Laborant Not Updated");
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
                }

                responseBody.put("status", "Ok");
                responseBody.put("message", "Laborant Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
            }

            responseBody.put("status", "Denied");
            responseBody.put("message", "Not Acceptable Form");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);

        } catch (Exception e) {
            responseBody.put("status", "Error");
            responseBody.put("message", "Laborant Not Updated");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    // -- Admin Delete Laborant | Complated --
    @DeleteMapping("/laborant")
    public ResponseEntity<?> deleteLaborant(@RequestBody AdminLaborantDeleteForm form) {
        Map<String, Object> responseBody = new HashMap<>();
        try {
            form.setQueryValues();
            if (form.getIsAcceptable() == true) {
                Laborant laborant = this.laborantService.getByUUID(Laborant.class, form.getQueryLaborantUUID());                
                
                if (laborant != null) {
                    Boolean result = this.laborantService.deleteLaborant(laborant);
                    
                    if (result == true) {
                        responseBody.put("status", "Ok");
                        responseBody.put("message", "Laborant Deleted");
                        return ResponseEntity.ok(responseBody);    
                    }

                    responseBody.put("status", "Error");
                    responseBody.put("message", "Laborant Not Deleted");
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
                }

                responseBody.put("status", "Ok");
                responseBody.put("message", "Laborant Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
            }

            responseBody.put("status", "Denid");
            responseBody.put("message", "Not Acceptable Form");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);

        } catch (Exception e) {
            responseBody.put("status", "Error");
            responseBody.put("message", "Laborant Not Deleted");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
    
    
    

    // -----*******************-----
    //          /Reports
    // -----*******************-----
    
    // -- Admin Show Reports | Completed --
    @GetMapping("/reports")
    public ResponseEntity<?> getReports(@RequestBody AdminReportGetForms form) {
        Map<String, Object> responseBody = new HashMap<>();
        try {
            form.setQueryValues();
            
            if (form.getIsRequestedList()) {
                List <ReportSafe> reports = null;

                if (form.getQueryPatientUUID() != null) {
                    reports = this.reportService.getAllByUserUUID(ReportSafe.class, form.getQueryIsVisible(), form.getQueryPatientUUID(), form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
                }
                else if (form.getQueryLaborantUUID() != null) {
                    reports = this.reportService.getAllByLaborantUUID(ReportSafe.class, form.getQueryIsVisible(), form.getQueryLaborantUUID(), form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
                }
                else if (form.getQueryIsVisible() == true) {
                    reports = this.reportService.getAll(ReportSafe.class, form.getQueryIsVisible(), form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
                }
                else {
                    responseBody.put("status", "Denied");
                    responseBody.put("message", "Request Not Acceptable");
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);
                }
                responseBody.put("data", reports);
                responseBody.put("status", "Ok");
                responseBody.put("message", "Reports Listed");
                return ResponseEntity.ok(responseBody);
            } else if (form.getIsRequestedOne()) {                
                ReportSafe report = null;
                if (form.getQueryReportUUID() != null) {
                    report = this.reportService.getByReportUUID(ReportSafe.class, form.getQueryIsVisible(), form.getQueryPatientUUID(), form.getQueryLaborantUUID(), form.getQueryReportUUID());
                } 
                else if (form.getQueryReportNumber() != null) {
                    report = this.reportService.getByReportNumber(ReportSafe.class, form.getQueryIsVisible(), form.getQueryPatientUUID(), form.getQueryLaborantUUID(), form.getQueryReportNumber());
                }
                else if (form.getQueryReportID() != null) {
                    report = this.reportService.getByReportId(ReportSafe.class, form.getQueryIsVisible(), form.getQueryPatientUUID(), form.getQueryLaborantUUID(), form.getQueryReportID());
                }
                else {
                    responseBody.put("status", "Ok");
                    responseBody.put("message", "Report Not Found");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
                }

                if (report != null) {
                    responseBody.put("data", report);
                    responseBody.put("status", "Ok");
                    responseBody.put("message", "Report Found");
                    return ResponseEntity.ok(responseBody);
                } else {
                    responseBody.put("status", "Ok");
                    responseBody.put("message", "Report Not Found");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
                }
            }
            
            responseBody.put("status", "Ok");
            responseBody.put("message", "Not Requested A List or A Report");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);

        } catch (Exception e) {
            responseBody.put("status", "Error");
            responseBody.put("message", "Reports Not Listed");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        
    }
    
    // -- Admin Show Report | Completed --
    @GetMapping("/report")
    public ResponseEntity<?> getReport(@RequestBody AdminReportGetForms form) {
        Map<String, Object> responseBody = new HashMap<>();
        try {
            form.setQueryValues();
            
            if (form.getIsRequestedOne()) {                
                Report report = null;
                if (form.getQueryReportUUID() != null) {
                    report = this.reportService.getByReportUUID(Report.class, form.getQueryIsVisible(), form.getQueryPatientUUID(), form.getQueryLaborantUUID(), form.getQueryReportUUID());
                } 
                else if (form.getQueryReportNumber() != null) {
                    report = this.reportService.getByReportNumber(Report.class, form.getQueryIsVisible(), form.getQueryPatientUUID(), form.getQueryLaborantUUID(), form.getQueryReportNumber());
                }
                else if (form.getQueryReportID() != null) {
                    report = this.reportService.getByReportId(Report.class, form.getQueryIsVisible(), form.getQueryPatientUUID(), form.getQueryLaborantUUID(), form.getQueryReportID());
                }

                if (report != null) {
                    report.maskIdentificationNumber();
                    responseBody.put("data", report);
                    responseBody.put("status", "Ok");
                    responseBody.put("message", "Report Found");
                    return ResponseEntity.ok(responseBody);
                } 
                
                responseBody.put("status", "Ok");
                responseBody.put("message", "Report Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
                
            }
            
            responseBody.put("status", "Denied");
            responseBody.put("message", "Requested To Many Reports");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);

        } catch (Exception e) {
            System.err.println(e);
            responseBody.put("status", "Error");
            responseBody.put("message", "Reports Not Listed");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    // -- Admin Report Update | Complated --
    @PostMapping("/report")
    public ResponseEntity<?> postReport(@RequestBody AdminReportPostForm form) {
        Map<String, Object> responseBody = new HashMap<>();
        try {
            form.setQueryValues();
            if (form.getIsAcceptable() == true) {
                
                Report report = this.reportService.getByReportUUID(Report.class, null, appDomain, appProtocol, form.getQueryReportUUID()); // Is report exist
                if (report != null) {

                    Boolean result = this.reportService.updateReportByUUID(form.getQueryReportUUID(), form.getQueryVisibilty()); // Update
                    if (result == true) {
                        responseBody.put("status", "Ok");
                        responseBody.put("message", "Report Updated");
                        return ResponseEntity.ok(responseBody);
                    }
                }

                responseBody.put("status", "Ok");
                responseBody.put("message", "Report Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
            }

            responseBody.put("status", "Denied");
            responseBody.put("message", "Not Acceptable Form");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);

        } catch (Exception e) {
            System.err.println(e);
            responseBody.put("status", "Error");
            responseBody.put("message", "Report Not Updated");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        }
    }

    // -- Admin Report Delete | Complated -- 
    @DeleteMapping("/report")
    public ResponseEntity<?> deleteReport(@RequestBody AdminReportDeleteForm form) {
        // Take Report with uuid and delete it
        Map<String, Object> responseBody = new HashMap<>();
        try {
            form.setQueryValues();
            if (form.getIsAcceptable() == true) {
                Report report = this.reportService.getByReportUUID(Report.class, null, null, null, form.getReportUUID());
                if (report != null) {
                    Boolean result = this.reportService.deleteReportByUUID(report.getUUID());
                    if (result == true) {   
                        responseBody.put("status", "Ok");
                        responseBody.put("message", "Report Deleted");
                        return ResponseEntity.ok(responseBody);
                    }

                    throw new Exception("Report Not Deleted");                    
                }

                responseBody.put("status", "Ok");
                responseBody.put("message", "Report Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
            }

            responseBody.put("status", "Denied");
            responseBody.put("message", "Not Acceptable Form");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseBody);

        } catch (Exception e) {
            System.err.println(e);
            responseBody.put("status", "Error");
            responseBody.put("message", "Report Not Deleted");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        }
    }


}
