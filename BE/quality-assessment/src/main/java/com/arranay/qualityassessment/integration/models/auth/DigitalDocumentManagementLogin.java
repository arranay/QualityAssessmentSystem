package com.arranay.qualityassessment.integration.models.auth;

public class DigitalDocumentManagementLogin {
    private String email;
    private String password;

    public DigitalDocumentManagementLogin() {}
    public DigitalDocumentManagementLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }

    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}
