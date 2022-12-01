package com.arranay.qualityassessment.quality_assessment.controllers;

import com.arranay.qualityassessment.integration.services.documents.DigitalDocumentManagementDocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @PostMapping()
    public ResponseEntity<Object> logout() {
        DigitalDocumentManagementDocumentService.createDocument();
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }
}
