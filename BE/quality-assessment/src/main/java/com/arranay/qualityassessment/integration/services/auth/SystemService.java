package com.arranay.qualityassessment.integration.services.auth;

import com.arranay.qualityassessment.integration.models.DigitalDocumentManagementSystem;
import com.arranay.qualityassessment.integration.models.SystemState;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SystemService {
    private static String url;
    private String login;
    private String password;
    private static WebClient webClient;

    public SystemService(
            @Value("${digital_document_management_system.url}") String systemUrl,
            @Value("${digital_document_management_system.login}") String systemLogin,
            @Value("${digital_document_management_system.password}") String systemPassword
    ) {
        url = systemUrl;
        login = systemLogin;
        password = systemPassword;

        webClient = WebClient.builder().baseUrl(url).build();
    }

    public static SystemState getSystemState() {
        DigitalDocumentManagementSystem system = webClient.get()
                .uri("/system-state")
                .retrieve()
                .bodyToMono(DigitalDocumentManagementSystem.class)
                .block();

        return system.getSystemState();
    }
}
