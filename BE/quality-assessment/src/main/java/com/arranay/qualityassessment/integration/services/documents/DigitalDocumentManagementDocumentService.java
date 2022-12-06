package com.arranay.qualityassessment.integration.services.documents;

import com.arranay.qualityassessment.integration.models.documents.CreateDocumentModel;
import com.arranay.qualityassessment.integration.models.documents.DocumentModel;
import com.arranay.qualityassessment.integration.services.IntegrationService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DigitalDocumentManagementDocumentService {

    public static Flux createDocuments(List<CreateDocumentModel> documents) {
        return Flux.fromIterable(documents).flatMapSequential(DigitalDocumentManagementDocumentService::createDocument);
    }
    public static Flux issueDocuments(List<String> documentIds) {
        return Flux.fromIterable(documentIds).flatMapSequential(DigitalDocumentManagementDocumentService::issueDocument);
    }

    private static Mono<DocumentModel> createDocument(CreateDocumentModel document) {
        return IntegrationService.getWebClient().post()
                .uri("api/documents")
                .cookies(cookies -> cookies.addAll(IntegrationService.getMyCookies()))
                .body(Mono.just(document), CreateDocumentModel.class)
                .retrieve()
                .bodyToMono(DocumentModel.class);
    }

    private static Mono<DocumentModel> issueDocument(String id) {
        return IntegrationService.getWebClient().post()
                .uri("api/documents/" + id + "/issue")
                .cookies(cookies -> cookies.addAll(IntegrationService.getMyCookies()))
                .retrieve()
                .bodyToMono(DocumentModel.class);
    }
}
