package com.arranay.qualityassessment.quality_assessment.controllers;

import com.arranay.qualityassessment.integration.services.auth.SystemService;
import com.arranay.qualityassessment.quality_assessment.models.Login;
import com.arranay.qualityassessment.quality_assessment.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping(path = "/login")
    public ResponseEntity<Object> login(@RequestBody Login login) {
        SystemService.getSystemState();
        if (AuthService.isCorrectCredentials(login))
            return new ResponseEntity<Object>(null, HttpStatus.OK);
        else
            return new ResponseEntity<Object>(null, HttpStatus.FORBIDDEN);
    }

    @PostMapping(path = "/logout")
    public ResponseEntity<Object> logout() {
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }
}
