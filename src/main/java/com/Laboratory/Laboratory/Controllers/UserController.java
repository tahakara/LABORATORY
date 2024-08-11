package com.Laboratory.Laboratory.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Laboratory.Laboratory.Entities.User;
import com.Laboratory.Laboratory.Services.Interfaces.IAuthService;
import com.Laboratory.Laboratory.Services.Interfaces.ILaborantService;
import com.Laboratory.Laboratory.Services.Interfaces.IPhotoService;
import com.Laboratory.Laboratory.Services.Interfaces.IRedisService;
import com.Laboratory.Laboratory.Services.Interfaces.IReportService;
import com.Laboratory.Laboratory.Services.Interfaces.IUserService;

import com.Laboratory.Laboratory.Entities.Laborant;
import com.Laboratory.Laboratory.Entities.Report;
import com.Laboratory.Laboratory.Entities.Photo;

@RestController
@RequestMapping("/user")
public class UserController {

    private IRedisService redisService;
    private IAuthService authService;
    private ILaborantService laborantService;
    private IReportService reportService;
    private IUserService userService;
    private IPhotoService photoService;

    @Autowired
    public UserController(IRedisService redisService, IAuthService authService, ILaborantService laborantService, IReportService reportService, IUserService userService, IPhotoService photoService) {
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

    // User Login
    @GetMapping("/login")
    public String login() {
        return "Get Login";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return "Post Login";
    }


    // User Logout
    @GetMapping("/logout")
    public String logout() {
        return "Get Logout";
    }

    @PostMapping("/logout")
    public String logout(@RequestBody User user) {
        return "Post Logout";
    }


    // User Profile
    @GetMapping("/profile")
    public String profile() {
        return "Get Profile";
    }

    @PostMapping("/profile")
    public String profile(@RequestBody User user) {
        return "Post Profile";
    }


    // User Reports
    @GetMapping("/reports")
    public String reports() {
        return "Get Reports";
    }

    @PostMapping("/reports")
    public String reports(@RequestBody User user) {
        return "Post Reports";
    }

}
