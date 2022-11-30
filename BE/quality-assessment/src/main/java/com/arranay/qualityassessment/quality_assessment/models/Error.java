package com.arranay.qualityassessment.quality_assessment.models;

import org.springframework.http.HttpStatus;

public class Error {
    HttpStatus code;
    String msg;

    public Error() {};
    public Error(HttpStatus code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public HttpStatus getCode() { return code; }
    public String getMsg() { return msg; }

    public void setCode(HttpStatus code) { this.code = code; }
    public void setMsg(String msg) { this.msg = msg; }
}