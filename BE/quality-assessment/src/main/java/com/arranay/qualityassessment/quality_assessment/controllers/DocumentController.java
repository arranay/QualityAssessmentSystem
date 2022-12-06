package com.arranay.qualityassessment.quality_assessment.controllers;

import com.arranay.qualityassessment.quality_assessment.repositories.DocumentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    private final DocumentRepository repository;

    public DocumentController(DocumentRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public ResponseEntity<Object> getDocuments() {
        try {
            return new ResponseEntity<Object>(this.repository.findAll(), HttpStatus.OK);
        } catch (ResponseStatusException exception) {
            return new ResponseEntity<Object>(null, exception.getStatusCode());
        }
    }
}
