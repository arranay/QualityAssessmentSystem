package com.arranay.qualityassessment.quality_assessment.services;

import com.arranay.qualityassessment.integration.models.documents.CreateDocumentModel;
import com.arranay.qualityassessment.integration.models.documents.DocumentModel;
import com.arranay.qualityassessment.integration.models.verifications.CreateVerificationModel;
import com.arranay.qualityassessment.integration.models.verifications.VerificationModel;
import com.arranay.qualityassessment.integration.services.documents.DigitalDocumentManagementDocumentService;
import com.arranay.qualityassessment.integration.services.verifications.DigitalDocumentManagementVerificationService;
import com.arranay.qualityassessment.quality_assessment.db_models.DocumentItem;
import com.arranay.qualityassessment.quality_assessment.db_models.VerificationItem;
import com.arranay.qualityassessment.quality_assessment.models.test.CreateTestModel;
import com.arranay.qualityassessment.quality_assessment.repositories.DocumentRepository;
import com.arranay.qualityassessment.quality_assessment.repositories.VerificationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    private static DocumentRepository docRepository;
    private static VerificationRepository verRepository;

    public TestService(
            DocumentRepository newDocRepository,
            VerificationRepository newVerRepository
    ) {
        docRepository = newDocRepository;
        verRepository = newVerRepository;
    }

    public static void createTest(CreateTestModel createModel) {
        List<String> docIds = new ArrayList<>();
        List<String> verIds = new ArrayList<>();

        createModel.getDocuments().forEach(doc -> docIds.add(doc.getId()));
        createModel.getVerifications().forEach(doc -> verIds.add(doc.getId()));

        List<DocumentItem> documents = docRepository.findAllById(docIds);
        List<VerificationItem> verifications = verRepository.findAllById(verIds);

        List<CreateDocumentModel> createDocumentModels = new ArrayList<>();
        documents.forEach(doc -> createDocumentModels.add(new CreateDocumentModel(
                doc.getName(),
                doc.getValues(),
                doc.getTemplateId(),
                doc.getIssuerWalletId(),
                doc.getOwnerWalletId(),
                doc.getOwnerWalletConnectionId(),
                doc.getIssuerWalletConnectionId()
        )));

        List<CreateVerificationModel> createVerificationModels = new ArrayList<>();
        verifications.forEach(doc -> createVerificationModels.add(new CreateVerificationModel(
                doc.getName(),
                doc.getDescription(),
                doc.getAdditionalTemplates(),
                doc.getVerificationFlowTemplates(),
                doc.getHolderWalletId(),
                doc.getHolderWalletConnectionId(),
                doc.getVerifiedWithId(),
                doc.getVerificationFlowId()
        )));

        createDocuments(createDocumentModels);
        createVerifications(createVerificationModels);
    }

    private static void createDocuments(List<CreateDocumentModel> createDocumentModels) {
        List<DocumentModel> createdDocuments = (List<DocumentModel>) DigitalDocumentManagementDocumentService
                .createDocuments(createDocumentModels)
                .collectList()
                .block();

        if (createdDocuments != null) {
            while (createdDocuments.size() !=0) {
                List<String> documentIds = new ArrayList<>();
                createdDocuments.forEach(documentModel -> documentIds.add(documentModel.get_id()));

                List<DocumentModel> issuedDocuments = (List<DocumentModel>) DigitalDocumentManagementDocumentService
                        .issueDocuments(documentIds)
                        .collectList()
                        .block();


                List<String> issuedDocIds = new ArrayList<>();
                issuedDocuments.forEach(documentModel -> {
                    if (documentModel.getStatus().equals("draft")) issuedDocIds.add(documentModel.get_id());
                });
                createdDocuments.removeIf(s -> !issuedDocIds.contains(s.get_id()));
            }

        }
    }

    public static void createVerifications(List<CreateVerificationModel> createVerificationModels) {
        List<VerificationModel> createdVerifications = (List<VerificationModel>) DigitalDocumentManagementVerificationService
                .sendVerifications(createVerificationModels)
                .collectList()
                .block();
    }
}
