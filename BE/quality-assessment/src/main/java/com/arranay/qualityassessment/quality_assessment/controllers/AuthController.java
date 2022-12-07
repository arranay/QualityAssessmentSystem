package com.arranay.qualityassessment.quality_assessment.controllers;

import com.arranay.qualityassessment.integration.models.auth.DigitalDocumentManagementSystemState;
import com.arranay.qualityassessment.integration.models.auth.DigitalDocumentManagementUser;
import com.arranay.qualityassessment.integration.services.auth.DigitalDocumentManagementAuthService;
import com.arranay.qualityassessment.quality_assessment.models.Error;
import com.arranay.qualityassessment.quality_assessment.models.auth.Login;
import com.arranay.qualityassessment.quality_assessment.models.auth.User;
import com.arranay.qualityassessment.quality_assessment.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping(path = "/login")
    public ResponseEntity<Object> login(@RequestBody Login login) {
        if (AuthService.isCorrectCredentials(login)) {
            DigitalDocumentManagementSystemState state = DigitalDocumentManagementAuthService.getSystemState();

            DigitalDocumentManagementUser user = new DigitalDocumentManagementUser();
            if (state == DigitalDocumentManagementSystemState.ACTIVE)
                user = DigitalDocumentManagementAuthService.Login();

            User systemUser = new User(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getPhoneNumber(),
                    user.getIcon(),
                    user.getCreatedAt(),
                    user.getEmail(),
                    state
            );
            return new ResponseEntity<Object>(systemUser, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Object>(
                    new Error(HttpStatus.FORBIDDEN, "Invalid credentials"),
                    HttpStatus.FORBIDDEN
            );
        }
    }

    @PostMapping(path = "/logout")
    public ResponseEntity<Object> logout() {
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }
}
