package com.arranay.qualityassessment.quality_assessment.services;

import com.arranay.qualityassessment.quality_assessment.models.auth.Login;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private static String login;
    private static String password;

    public AuthService(
            @Value("${quality_assessment.login}") String userLogin,
            @Value("${quality_assessment.password}") String userPassword
    ) {
        login = userLogin;
        password = userPassword;
    }

    public static boolean isCorrectCredentials(Login loginCredentials) {
        return login.equals(loginCredentials.getLogin()) &&
                password.equals(loginCredentials.getPassword());
    }
}
