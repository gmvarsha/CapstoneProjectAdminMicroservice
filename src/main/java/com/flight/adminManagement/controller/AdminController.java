package com.flight.adminManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flight.adminManagement.model.AdminUser;
import com.flight.adminManagement.service.AdminService;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        try {
            AdminUser adminUser = adminService.findByEmail(email);
            if (adminUser == null || !adminService.validatePassword(password, adminUser.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
            if (adminUser != null) {
                // Authentication successful
                return ResponseEntity.ok(new Object() {
                    public Long userId = adminUser.getId();
                    public String email = adminUser.getEmail();
                    public String role = adminUser.getRole();
                });
            } else {
                // Authentication failed
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email/password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during login");
        }
    }
    @PostMapping("/signUp")
    public ResponseEntity<?> signup(@RequestBody AdminUser adminUser) {
        if (adminService.findByEmail(adminUser.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already in use");
        }
        adminService.saveUser(adminUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    // Other endpoints and methods
}



