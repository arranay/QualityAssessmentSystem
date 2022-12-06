package com.arranay.qualityassessment.quality_assessment.services;

import com.arranay.qualityassessment.integration.models.documents.CreateDocumentModel;
import com.arranay.qualityassessment.integration.models.documents.DocumentModel;
import com.arranay.qualityassessment.integration.models.documents.DocumentValues;
import com.arranay.qualityassessment.integration.models.verifications.CreateVerificationModel;
import com.arranay.qualityassessment.integration.models.verifications.TemplateModel;
import com.arranay.qualityassessment.integration.models.verifications.VerificationModel;
import com.arranay.qualityassessment.integration.services.documents.DigitalDocumentManagementDocumentService;
import com.arranay.qualityassessment.integration.services.verifications.DigitalDocumentManagementVerificationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    public static void createDocuments() {
        List<CreateDocumentModel> documents = new ArrayList<>();
        documents.add(getDocumentMock("demo doc 1"));
        documents.add(getDocumentMock("demo doc 2"));
        documents.add(getDocumentMock("demo doc 3"));

        List<DocumentModel> createdDocuments = (List<DocumentModel>) DigitalDocumentManagementDocumentService
                .createDocuments(documents)
                .collectList()
                .block();

        if (createdDocuments != null) {
            while (
                    createdDocuments.size() !=0 &&
                    !createdDocuments.removeIf(s -> s.getStatus().equals("done"))
            ) {
                List<String> documentIds = new ArrayList<>();
                createdDocuments.forEach(documentModel -> {
                    if (documentModel.getStatus().equals("draft")) documentIds.add(documentModel.get_id());
                });

                createdDocuments = (List<DocumentModel>) DigitalDocumentManagementDocumentService
                        .issueDocuments(documentIds)
                        .collectList()
                        .block();
            }

        }
    }

    public static void createVerifications() {
        List<CreateVerificationModel> verifications = new ArrayList<>();
        verifications.add(getVerificationMock("demo ver 1"));
        verifications.add(getVerificationMock("demo ver 2"));
        verifications.add(getVerificationMock("demo ver 3"));

        List<VerificationModel> createdVerifications = (List<VerificationModel>) DigitalDocumentManagementVerificationService
                .sendVerifications(verifications)
                .collectList()
                .block();

        createdVerifications.forEach(ver -> System.out.println(ver));
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

    private static CreateVerificationModel getVerificationMock(String name) {
        ArrayList<TemplateModel> additionalTemplates = new ArrayList<TemplateModel>();
        ArrayList<TemplateModel> verificationFlowTemplates = new ArrayList<TemplateModel>();

        return new CreateVerificationModel(
                name,
                "any description",
                additionalTemplates,
                verificationFlowTemplates,
                "632b05d1d1f77a004283a607",
                null,
                "632b05d1d1f77a004283a607",
                "638f1164dacc71004277ee6e"
        );
    }
}
