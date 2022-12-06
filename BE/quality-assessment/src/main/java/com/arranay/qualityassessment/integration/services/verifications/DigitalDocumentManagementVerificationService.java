package com.arranay.qualityassessment.integration.services.verifications;

import com.arranay.qualityassessment.integration.models.verifications.CreateVerificationModel;
import com.arranay.qualityassessment.integration.models.verifications.VerificationModel;
import com.arranay.qualityassessment.integration.services.IntegrationService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class DigitalDocumentManagementVerificationService {
    public static Flux sendVerifications(List<CreateVerificationModel> verifications) {
        return Flux.fromIterable(verifications).flatMapSequential(DigitalDocumentManagementVerificationService::sendVerification);
    }
    private static Mono<VerificationModel> sendVerification(CreateVerificationModel verification) {
        return IntegrationService.getWebClient().post()
                .uri("api/verifications")
                .cookies(cookies -> cookies.addAll(IntegrationService.getMyCookies()))
                .body(Mono.just(verification), CreateVerificationModel.class)
                .retrieve()
                .bodyToMono(VerificationModel.class);
    }
}
