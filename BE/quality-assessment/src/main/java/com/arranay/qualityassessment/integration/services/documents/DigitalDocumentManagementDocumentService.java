package com.arranay.qualityassessment.integration.services.documents;

import com.arranay.qualityassessment.integration.models.documents.CreateDocumentModel;
import com.arranay.qualityassessment.integration.models.documents.DocumentValues;
import com.arranay.qualityassessment.integration.services.IntegrationService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
public class DigitalDocumentManagementDocumentService {

    public static CreateDocumentModel createDocument() {
        ArrayList<DocumentValues> values = new ArrayList<DocumentValues>();
        DocumentValues value = new DocumentValues("test", "test");
        values.add(value);

        CreateDocumentModel document = new CreateDocumentModel(
                "document test",
                values,
                "63871f5aa9cada004241061c",
                "632b05d1d1f77a004283a607",
                "632b05d1d1f77a004283a607",
                null,
                null
        );
        return IntegrationService.getWebClient().post()
                .uri("api/documents")
                .cookies(cookies -> cookies.addAll(IntegrationService.getMyCookies()))
                .body(Mono.just(document), CreateDocumentModel.class)
                .retrieve()
                .bodyToMono(CreateDocumentModel.class)
                .block();
    }

    public void issueDocument() {

    }
}
