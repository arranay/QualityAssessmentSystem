package com.arranay.qualityassessment.integration.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class IntegrationService {
    private static WebClient webClient;
    private static MultiValueMap<String, String> myCookies = new LinkedMultiValueMap<String, String>();

    public IntegrationService(
            @Value("${digital_document_management_system.url}") String systemUrl
    ) {
        webClient = WebClient.builder().baseUrl(systemUrl).build();
    }

    public static MultiValueMap<String, String> getMyCookies() { return myCookies; }
    public static WebClient getWebClient() { return webClient; }

    public static void setMyCookies(MultiValueMap<String, String> newCookies) { myCookies = newCookies; }
}
