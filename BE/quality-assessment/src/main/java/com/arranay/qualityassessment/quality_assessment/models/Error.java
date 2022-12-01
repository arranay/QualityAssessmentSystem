package com.arranay.qualityassessment.quality_assessment.models;

import org.springframework.http.HttpStatus;

public class Error {
    HttpStatus code;
    String message;

    public Error() {};
    public Error(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpStatus getCode() { return code; }
    public String getMessage() { return message; }

    public void setCode(HttpStatus code) { this.code = code; }
    public void setMessage(String message) { this.message = message; }
}