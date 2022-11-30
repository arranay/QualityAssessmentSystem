package com.arranay.qualityassessment.integration.services.auth;

import com.arranay.qualityassessment.integration.models.auth.DigitalDocumentManagementSystem;
import com.arranay.qualityassessment.integration.models.auth.DigitalDocumentManagementSystemState;
import com.arranay.qualityassessment.integration.models.auth.DigitalDocumentManagementLogin;
import com.arranay.qualityassessment.integration.models.auth.DigitalDocumentManagementUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DigitalDocumentManagementAuth {
    private static String email;
    private static String password;
    private static WebClient webClient;

    public DigitalDocumentManagementAuth(
            @Value("${digital_document_management_system.url}") String systemUrl,
            @Value("${digital_document_management_system.email}") String systemEmail,
            @Value("${digital_document_management_system.password}") String systemPassword
    ) {
        email = systemEmail;
        password = systemPassword;

        webClient = WebClient.builder().baseUrl(systemUrl).build();
    }

    public static DigitalDocumentManagementSystemState getSystemState() {
        DigitalDocumentManagementSystem system = webClient.get()
                .uri("api/system-state")
                .retrieve()
                .bodyToMono(DigitalDocumentManagementSystem.class)
                .block();

        return system.getSystemState();
    }

    public static DigitalDocumentManagementUser Login() {
        DigitalDocumentManagementLogin login = new DigitalDocumentManagementLogin(email, password);
        return webClient.post()
                .uri("api/auth/login")
                .body(Mono.just(login), DigitalDocumentManagementLogin.class)
                .retrieve()
                .bodyToMono(DigitalDocumentManagementUser.class)
                .block();
    }
}
