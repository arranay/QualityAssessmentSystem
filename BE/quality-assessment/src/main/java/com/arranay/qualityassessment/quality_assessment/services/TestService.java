package com.arranay.qualityassessment.quality_assessment.services;

import com.arranay.qualityassessment.integration.models.documents.CreateDocumentModel;
import com.arranay.qualityassessment.integration.models.documents.DocumentModel;
import com.arranay.qualityassessment.integration.models.documents.DocumentValues;
import com.arranay.qualityassessment.integration.services.documents.DigitalDocumentManagementDocumentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {
    public static void createDocuments() {
        List<CreateDocumentModel> documents = new ArrayList<>();
        documents.add(getDocumentMock("doc 1"));
        documents.add(getDocumentMock("doc 2"));
        documents.add(getDocumentMock("doc 3"));

        List<DocumentModel> createdDocuments = (List<DocumentModel>) DigitalDocumentManagementDocumentService
                .createDocuments(documents)
                .collectList()
                .block();

        List<String> documentIds = new ArrayList<>();
        if (createdDocuments != null) {
            createdDocuments.forEach(documentModel -> documentIds.add(documentModel.get_id()));
            List<DocumentModel> issuedDocuments = (List<DocumentModel>) DigitalDocumentManagementDocumentService
                    .issueDocuments(documentIds)
                    .collectList()
                    .block();
        }
    }

    private static CreateDocumentModel getDocumentMock(String name) {
        ArrayList<DocumentValues> values = new ArrayList<DocumentValues>();
        DocumentValues value = new DocumentValues("test", "test");
        values.add(value);

        return new CreateDocumentModel(
                name,
                values,
                "63871f5aa9cada004241061c",
                "632b05d1d1f77a004283a607",
                "632b05d1d1f77a004283a607",
                null,
                null
        );
    }
}
