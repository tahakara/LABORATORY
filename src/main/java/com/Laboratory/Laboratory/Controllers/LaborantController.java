package com.Laboratory.Laboratory.Controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Laboratory.Laboratory.Entities.Laborant;
import com.Laboratory.Laboratory.Entities.Report;
import com.Laboratory.Laboratory.Entities.User;
import com.Laboratory.Laboratory.Services.Interfaces.IAuthService;
import com.Laboratory.Laboratory.Services.Interfaces.ILaborantService;
import com.Laboratory.Laboratory.Services.Interfaces.IPhotoService;
import com.Laboratory.Laboratory.Services.Interfaces.IRedisService;
import com.Laboratory.Laboratory.Services.Interfaces.IReportService;
import com.Laboratory.Laboratory.Services.Interfaces.IUserService;

import com.Laboratory.Laboratory.Entities.FormEntities.Laborant.*;
import com.Laboratory.Laboratory.Entities.SafeEntities.ReportSafe;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.Laboratory.Laboratory.Entities.Photo;

@RestController
@RequestMapping("/laborant")
public class LaborantController {
    private IRedisService redisService;
    private IAuthService authService;
    private ILaborantService laborantService;
    private IReportService reportService;
    private IUserService userService;
    private IPhotoService photoService;

    @Autowired
    public LaborantController(IRedisService redisService, IAuthService authService, ILaborantService laborantService, IReportService reportService, IUserService userService, IPhotoService photoService) {
        this.redisService = redisService;
        this.authService = authService;
        this.laborantService = laborantService;
        this.reportService = reportService;
        this.userService = userService;
        this.photoService = photoService;
    }

    // -----*******************-----
    //          Mappings
    // -----*******************-----

    // -- Laborant Login | Complated --
    @PostMapping("/login")
    public ResponseEntity<?> loginPost(@RequestBody LaborantLoginPostForm form, HttpServletRequest request, HttpServletResponse response) {
    
        Laborant laborant = null;
        Map<String,Object> responseBody = new HashMap<>();
        HttpHeaders responseHeaders = new HttpHeaders();

        if (form.getIsAcceptable()) {

            if (form.getIdentificationAndPassword()) {
                laborant = this.laborantService.getByEmailAndPassword(Laborant.class, form.getEmail(), form.getPassword());
                responseBody.put("type", "IdentificaitonCard");
            }
            else if (form.getHospitalIdAndPassword()) {
                laborant = this.laborantService.getByHospitalIDAndPassword(Laborant.class, form.getHospitalId(), form.getPassword());
                responseBody.put("type", "HospitalId");
            }
            else if (form.getEmailAndPassword()) {
                laborant = this.laborantService.getByEmailAndPassword(Laborant.class, form.getEmail(), form.getPassword());
                responseBody.put("type", "Email");
            }


            if (laborant == null) {
                responseBody.put("status", "Denied");
                responseBody.put("message", "Invalid Credentials");
                responseHeaders.add("Set-Cookie", "Auth-1=; Max-Age=0;");
                
                return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(responseHeaders).body(responseBody);
            }

            else {

                Map<String,Object> authPayload = Map.of(
                    "name", laborant.getName(),
                    "surname", laborant.getSurname(),
                    "hospitalId", laborant.getHospitalId(),
                    "UUID", laborant.getUuid()
                );

                String authJwtToken = this.authService.generateTokenDay(authPayload, 1);

                String redisKeyName = laborant.getUuid();

                Boolean redisResult = this.redisService.setLaborantKeyValueDay(redisKeyName, authJwtToken, 1)
                .onErrorReturn(false)
                .block() != null;;

                if (redisResult == false) {
                    responseBody.put("status", "Denied");
                    responseBody.put("message", "Redis Error");
                    responseHeaders.add("Set-Cookie", "Auth-1=; Max-Age=0;");
                } else {
                    responseBody.put("status", "Ok");
                    responseBody.put("message", "Login Success");
                    responseHeaders.add("Set-Cookie", "Auth-1=" + authJwtToken + "; Max-Age=3600;");
                }
                
                return ResponseEntity.ok().headers(responseHeaders).body(responseBody);
            }
        }

        responseBody.put("status", "Denied");
        responseBody.put("message", "Not Acceaptable Form");
        responseHeaders.add("Set-Cookie", "Auth-1=; Max-Age=0;");
        
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(responseHeaders).body(responseBody);
    }

    // -- Laborant Logout | Complated --
    @SuppressWarnings("null")
    @GetMapping("/logout")
    public ResponseEntity<?> logoutGet(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> responseBody = new HashMap<>();
        HttpHeaders responseHeaders = new HttpHeaders();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("Auth-1".equals(cookie.getName())) {

                    Map<String, Object> verifiedJwtToken = this.authService.verifyToken(cookie.getValue());
                    if (!verifiedJwtToken.isEmpty()) {
                        
                        this.redisService.deleteLaborantValueByKey(verifiedJwtToken.get("UUID").toString())
                            .onErrorReturn(false)
                            .block();
    
                    }
                    
                    Cookie newCookie = new Cookie("Auth-1", "");
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

    // -- Laborant Profile | Completed -- 
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(HttpServletRequest request, HttpServletResponse response) {
        Laborant laborant = null;
        Map<String, Object> responseBody = new HashMap<>();
        HttpHeaders responseHeaders = new HttpHeaders();
        
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("Auth-1".equals(cookie.getName())) {
                Map<String, Object> verifiedJwtToken = this.authService.verifyToken(cookie.getValue());
                if (!verifiedJwtToken.isEmpty()) {
                    laborant = this.laborantService.getByUUID(Laborant.class, verifiedJwtToken.get("UUID").toString());
                    if (laborant != null) {
                        responseBody.put("status", "Ok");
                        responseBody.put("message", "Profile Found");
                        responseBody.put("data", laborant);
                        return ResponseEntity.ok().headers(responseHeaders).body(responseBody);
                    }
                }
            }
        }
        
        responseHeaders.add("Set-Cookie", String.format("Auth-1=; Max-Age=0"));

        responseBody.put("status", "Denied");
        responseBody.put("message", "Unauthorized Access");
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).headers(responseHeaders).body(responseBody);
    }
   
    // -- Laborant Update Profile | Completed --
    @PutMapping("/profile")
    public ResponseEntity<?> putProfile(HttpServletRequest request, HttpServletResponse response, @RequestBody LaborantProfilePutForm form) {
        Laborant laborant = null;
        Map<String, Object> responseBody = new HashMap<>();
        HttpHeaders responseHeaders = new HttpHeaders();

        try {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if ("Auth-1".equals(cookie.getName())) {
                    Map<String, Object> verifiedJwtToken = this.authService.verifyToken(cookie.getValue());
                    if (!verifiedJwtToken.isEmpty()) {
                        laborant = this.laborantService.getByUUID(Laborant.class, verifiedJwtToken.get("UUID").toString());
                        if (laborant != null) {
                            form.setQueryValues();
                            laborant.setName(form.getQueryLaborantName() != null ? form.getQueryLaborantName() : laborant.getName());
                            laborant.setSurname(form.getQueryLaborantSurname() != null ? form.getQueryLaborantSurname() : laborant.getSurname());
                            laborant.setEmail(form.getQueryLaborantEmail() != null ? form.getQueryLaborantEmail() : laborant.getEmail());
                            laborant.setPassword(form.getQueryLaborantPassword() != null ? form.getQueryLaborantPassword() : laborant.getPassword());

                            Boolean result = this.laborantService.updateLaborant(laborant);
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
                        responseHeaders.add("Set-Cookie", String.format("Auth-1=; Max-Age=0"));
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(responseHeaders).body(responseBody);
                    }

                    responseBody.put("status", "Denied");
                    responseBody.put("message", "Unauthorized Access");
                    responseHeaders.add("Set-Cookie", String.format("Auth-1=; Max-Age=0"));
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).headers(responseHeaders).body(responseBody);
                }
            }
            
            responseBody.put("staus", "Denied");
            responseBody.put("message", "Unauthorized Access");
            responseHeaders.add("Set-Cookie", String.format("Auth-1=; Max-Age=0"));
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).headers(responseHeaders).body(responseBody);

        } catch (Exception e) {
            responseBody.put("status", "Error");
            responseBody.put("message", "Profile Not Updated");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
    
    
    

    // -----*******************-----
    //          /Reports
    // -----*******************-----
    
    // -- Laborant Show Reports | Completed --
    @GetMapping("/reports")
    public ResponseEntity<?> getReports(@RequestBody LaborantReportGetForms form, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> responseBody = new HashMap<>();
        try {
            Laborant laborant=null;

            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if ("Auth-1".equals(cookie.getName())) {
                    Map<String, Object> verifiedJwtToken = this.authService.verifyToken(cookie.getValue());
                    if (!verifiedJwtToken.isEmpty()) {
                        laborant = this.laborantService.getByUUID(Laborant.class, verifiedJwtToken.get("UUID").toString());
                        if (laborant == null) {
                            responseBody.put("status", "Denied");
                            responseBody.put("message", "Laborant Not Found");
                            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
                        }
                        else {
                            if (laborant.getUuid() != form.getQueryLaborantUUID()) {
                                responseBody.put("status", "Denied");
                                responseBody.put("message", "Unauthorized Access");
                                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
                            }
                        }
                    }
                }
            }

            form.setQueryValues();
            
            if (form.getIsRequestedList()) {
                List <ReportSafe> reports = null;

                // Burda kaldık düşün bakalım hastnaın nelerine ulaşabilmeli 
                if (form.getPatientUUID() != null) {
                    reports = this.reportService.getAllByUserUUIDAndLaborantUUID(ReportSafe.class, true, form.getQueryPatientUUID(), laborant.getUuid(), form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
                }
                else {
                    reports = this.reportService.getAllByLaborantUUID(ReportSafe.class, true, laborant.getUuid(), form.getQueryOffset(), form.getQueryLimit(), form.getQueryOrderBy(), form.getQueryOrderType(), form.getQueryFromDate(), form.getQueryToDate());
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
    

    // Laborant Single Report
    //Getting Report | Completed --
    @GetMapping("/report")
    public ResponseEntity<?> getReport(@RequestBody LaborantReportGetForms form, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> responseBody = new HashMap<>();
        try {
            Laborant laborant=null;

            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if ("Auth-1".equals(cookie.getName())) {
                    Map<String, Object> verifiedJwtToken = this.authService.verifyToken(cookie.getValue());
                    if (!verifiedJwtToken.isEmpty()) {
                        laborant = this.laborantService.getByUUID(Laborant.class, verifiedJwtToken.get("UUID").toString());
                        if (laborant == null) {
                            responseBody.put("status", "Denied");
                            responseBody.put("message", "Laborant Not Found");
                            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
                        }
                        else {
                            if (laborant.getUuid() != form.getQueryLaborantUUID()) {
                                responseBody.put("status", "Denied");
                                responseBody.put("message", "Unauthorized Access");
                                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
                            }
                        }
                    }
                }
            }

            form.setQueryValues();
            
            if (form.getIsRequestedOne()) {                
                Report report = null;

                if (form.getQueryReportUUID() != null) {
                    report = this.reportService.getByReportUUID(Report.class, true, form.getQueryPatientUUID(), form.getQueryLaborantUUID(), form.getQueryReportUUID());
                } 
                else if (form.getQueryReportNumber() != null) {
                    report = this.reportService.getByReportNumber(Report.class, true, form.getQueryPatientUUID(), form.getQueryLaborantUUID(), form.getQueryReportNumber());
                }
                else if (form.getQueryReportID() != null) {
                    report = this.reportService.getByReportId(Report.class, true, form.getQueryPatientUUID(), form.getQueryLaborantUUID(), form.getQueryReportID());
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
            
        } catch (Exception e) {
            responseBody.put("status", "Error");
            responseBody.put("message", "Reports Not Listed");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    // Creating New Report | Completed --
    @PostMapping("/report")
    public ResponseEntity<?> postReport(@RequestBody LaborantReportPostForm form, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> responseBody = new HashMap<>();
        try {
            form.setQueryValues();
            Laborant laborant = null;

            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if ("Auth-1".equals(cookie.getName())) {
                    Map<String, Object> verifiedJwtToken = this.authService.verifyToken(cookie.getValue());
                    if (!verifiedJwtToken.isEmpty()) {
                        laborant = this.laborantService.getByUUID(Laborant.class, verifiedJwtToken.get("UUID").toString());
                        if (laborant == null) {
                            responseBody.put("status", "Denied");
                            responseBody.put("message", "Laborant Not Found");
                            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
                        }
                        else {
                            if (laborant.getUuid() != form.getLaborantUUID()) {
                                responseBody.put("status", "Denied");
                                responseBody.put("message", "Unauthorized Access");
                                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
                            }
                        }
                    }
                    
                    responseBody.put("status", "Denied");
                    responseBody.put("message", "Unauthorized Access");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);

                }
            }

            Report report = this.reportService.getByReportNumber(Report.class, null, null, null, form.getReportNumber());
            if (report != null) {
                responseBody.put("status", "Ok");
                responseBody.put("message", "Report Already Exists");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(responseBody);
            }

            User patient = this.userService.getByIdentificationNumber(form.getPatientIdentificationNumber());
            if (patient != null) {
                form.setPatientUUID(patient.getUuid());
            }  

            Report newReport = new Report();
            newReport.setPatientUUID(form.getPatientUUID());
            newReport.setLaborantUUID(laborant.getUuid());
            newReport.setReportNumber(form.getReportNumber());
            newReport.setPatientName(form.getPatientName());
            newReport.setPatientSurname(form.getPatientSurname());
            newReport.setPatientIdentificationNumber(form.getPatientIdentificationNumber());
            newReport.setPatientBirthYear(form.getPatientBirthYear());
            newReport.setPatientBirthMonth(form.getPatientBirthMonth());
            newReport.setPatientBirthDay(form.getPatientBirthDay());
            newReport.setDiagnoseTitle(form.getDiagnoseTitle());
            newReport.setDiagnoseContent(form.getDiagnoseDescription());
            newReport.setIsVisible(true);
            newReport.setPhotoUrl(form.getReportPhoto());

            Boolean result = this.reportService.insertNewReport(newReport);

            if (result == true) {
                responseBody.put("status", "Ok");
                responseBody.put("message", "Report Created");
                return ResponseEntity.ok(responseBody);
            } else {
                responseBody.put("data", form);
                responseBody.put("status", "Error");
                responseBody.put("message", "Report Not Created");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
            }

        } catch (Exception e) {
            responseBody.put("data", form);
            responseBody.put("status", "Error");
            responseBody.put("message", "Report Not Created");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        }
    }

    // Updateing Report | Completed --
    @PutMapping("/report")
    public ResponseEntity<?> putReport(@RequestBody LaborantReportPostForm form, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> responseBody = new HashMap<>();
        try {
            form.setQueryValues();
            Laborant laborant = null;

            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if ("Auth-1".equals(cookie.getName())) {
                    Map<String, Object> verifiedJwtToken = this.authService.verifyToken(cookie.getValue());
                    if (!verifiedJwtToken.isEmpty()) {
                        laborant = this.laborantService.getByUUID(Laborant.class, verifiedJwtToken.get("UUID").toString());
                        if (laborant == null) {
                            responseBody.put("status", "Denied");
                            responseBody.put("message", "Laborant Not Found");
                            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
                        }
                        else {
                            if (laborant.getUuid() != form.getLaborantUUID()) {
                                responseBody.put("status", "Denied");
                                responseBody.put("message", "Unauthorized Access");
                                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
                            }
                        }
                    }
                    
                    responseBody.put("status", "Denied");
                    responseBody.put("message", "Unauthorized Access");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);

                }
            }

            Report report = this.reportService.getByReportNumber(Report.class, null, null, null, form.getReportNumber());
            if (report == null) {
                responseBody.put("status", "Ok");
                responseBody.put("message", "Report Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
            }
            
            report.setDiagnoseTitle(form.getDiagnoseTitle());            
            report.setDiagnoseContent(form.getDiagnoseDescription());
            report.setPhotoUrl(form.getReportPhoto());
            report.setPatientBirthDay(form.getPatientBirthDay());
            report.setPatientBirthMonth(form.getPatientBirthMonth());
            report.setPatientBirthYear(form.getPatientBirthYear());
            report.setPatientName(form.getPatientName());
            report.setPatientSurname(form.getPatientSurname());

            Boolean result = this.reportService.updateReportDetailByUUID(report.getUUID(), report);

            if (result == true) {
                responseBody.put("status", "Ok");
                responseBody.put("message", "Report Updated");
                return ResponseEntity.ok(responseBody);
            } else {
                responseBody.put("status", "Error");
                responseBody.put("data", form);
                responseBody.put("message", "Report Not Updated");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
            }

        } catch (Exception e) {
            responseBody.put("status", "Error");
            responseBody.put("message", "Report Not Updated");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        }

    }

    // Deleting Report | Completed --
    @DeleteMapping("/report")
    public ResponseEntity<?> deleteReport(@RequestBody LaborantReportDeleteForm form, HttpServletRequest request, HttpServletResponse response) {
        
        Map<String, Object> responseBody = new HashMap<>();
        try {
            form.setQueryValues();
            if (form.getIsAcceptable() == true) {
                Report report = this.reportService.getByReportUUID(Report.class, null, null, form.getQueryLaborantUUID(), form.getQueryReportUUID());
                if (report != null) {
                    Boolean result = this.reportService.updateReportByUUID(report.getUUID(), false);
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
