package com.arranay.qualityassessment.integration.services;

import com.arranay.qualityassessment.integration.models.Error;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
public class IntegrationService {
    private static WebClient webClient;
    private static MultiValueMap<String, String> myCookies = new LinkedMultiValueMap<String, String>();

    public IntegrationService(
            @Value("${digital_document_management_system.url}") String systemUrl
    ) {
        webClient = WebClient
                .builder()
                .filter(ExchangeFilterFunction.ofResponseProcessor(this::handlerErrorResponse))
                .baseUrl(systemUrl)
                .build();
    }

    public static MultiValueMap<String, String> getMyCookies() { return myCookies; }
    public static WebClient getWebClient() { return webClient; }

    public static void setMyCookies(MultiValueMap<String, String> newCookies) { myCookies = newCookies; }

    private Mono<ClientResponse> handlerErrorResponse(ClientResponse clientResponse) {
        if(clientResponse.statusCode().isError()){
            return clientResponse.bodyToMono(Error.class)
                    .flatMap(apiErrorResponse -> Mono.error(new ResponseStatusException(
                            clientResponse.statusCode(),
                            apiErrorResponse.getCode()
                    )));
        }
        return Mono.just(clientResponse);
    }
}
