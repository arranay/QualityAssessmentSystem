package com.arranay.qualityassessment.quality_assessment.models.auth;

public class Login {
    private String login;
    private String password;

    Login() {}

    Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() { return this.login; }
    public String getPassword() { return this.password; }

    public void setLogin(String login) { this.login = login; }
    public void setPassword(String password) { this.password = password; }
}
