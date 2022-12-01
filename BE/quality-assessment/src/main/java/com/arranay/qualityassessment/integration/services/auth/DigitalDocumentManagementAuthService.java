package com.arranay.qualityassessment.integration.services.auth;

import com.arranay.qualityassessment.integration.models.auth.*;
import com.arranay.qualityassessment.integration.services.IntegrationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;
import java.util.Arrays;

@Service
public class DigitalDocumentManagementAuthService {

    private static String email;
    private static String password;

    public DigitalDocumentManagementAuthService(
            @Value("${digital_document_management_system.email}") String systemEmail,
            @Value("${digital_document_management_system.password}") String systemPassword
    ) {
        email = systemEmail;
        password = systemPassword;
    }

    public static DigitalDocumentManagementSystemState getSystemState() {
        DigitalDocumentManagementSystem system = IntegrationService.getWebClient().get()
                .uri("api/system-state")
                .retrieve()
                .bodyToMono(DigitalDocumentManagementSystem.class)
                .block();

        return system.getSystemState();
    }

    public static DigitalDocumentManagementUser Login() {
        DigitalDocumentManagementLogin login = new DigitalDocumentManagementLogin(email, password);

        return IntegrationService.getWebClient().post()
                .uri("api/auth/login")
                .body(Mono.just(login), DigitalDocumentManagementLogin.class)
                .exchangeToMono(response -> {
                    MultiValueMap<String, String> myCookies = new LinkedMultiValueMap<String, String>();
                    for (String key: response.cookies().keySet()) {
                        myCookies.put(key, Arrays.asList(response.cookies().get(key).get(0).getValue()));
                    }
                    IntegrationService.setMyCookies(myCookies);

                    return response.bodyToMono(DigitalDocumentManagementUser.class);
                })
                .block();
    }
}
