package com.arranay.qualityassessment.integration.models;

public class Error {
    String code;

    public Error() {};
    public Error(String code, String msg) {
        this.code = code;
    }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }
}
