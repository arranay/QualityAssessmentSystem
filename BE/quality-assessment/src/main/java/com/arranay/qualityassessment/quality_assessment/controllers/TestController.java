package com.arranay.qualityassessment.quality_assessment.controllers;

import com.arranay.qualityassessment.quality_assessment.models.test.CreateTestModel;
import com.arranay.qualityassessment.quality_assessment.services.CreateTestService;
import com.arranay.qualityassessment.quality_assessment.services.GetTestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @PostMapping()
    public ResponseEntity<Object> startCheck(@RequestBody CreateTestModel createModel) {
        try {
            CreateTestService.createTest(createModel);
            return new ResponseEntity<Object>(null, HttpStatus.OK);
        } catch (ResponseStatusException exception) {
            return new ResponseEntity<Object>(null, exception.getStatusCode());
        }
    }

    @GetMapping ResponseEntity<Object> getAllCheck() {
        return new ResponseEntity<Object>(GetTestService.getAll(), HttpStatus.OK);
    }
}
