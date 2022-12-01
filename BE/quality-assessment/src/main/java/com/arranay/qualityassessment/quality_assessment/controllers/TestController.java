package com.arranay.qualityassessment.quality_assessment.controllers;

import com.arranay.qualityassessment.quality_assessment.services.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @PostMapping()
    public ResponseEntity<Object> startCheck() {
        try {
            TestService.createDocuments();
            return new ResponseEntity<Object>(null, HttpStatus.OK);
        } catch (ResponseStatusException exception) {
            return new ResponseEntity<Object>(null, exception.getStatusCode());
        }
    }

    @GetMapping ResponseEntity<Object> getAllCheck() {
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }
}
