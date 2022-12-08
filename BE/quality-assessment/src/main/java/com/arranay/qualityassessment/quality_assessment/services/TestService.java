package com.arranay.qualityassessment.quality_assessment.services;

import com.arranay.qualityassessment.integration.models.documents.CreateDocumentModel;
import com.arranay.qualityassessment.integration.models.documents.DocumentModel;
import com.arranay.qualityassessment.integration.models.verifications.CreateVerificationModel;
import com.arranay.qualityassessment.integration.models.verifications.VerificationModel;
import com.arranay.qualityassessment.integration.services.documents.DigitalDocumentManagementDocumentService;
import com.arranay.qualityassessment.integration.services.verifications.DigitalDocumentManagementVerificationService;
import com.arranay.qualityassessment.quality_assessment.db_models.DocumentItem;
import com.arranay.qualityassessment.quality_assessment.db_models.TestItem;
import com.arranay.qualityassessment.quality_assessment.db_models.VerificationItem;
import com.arranay.qualityassessment.quality_assessment.models.test.CreateTestModel;
import com.arranay.qualityassessment.quality_assessment.repositories.DocumentRepository;
import com.arranay.qualityassessment.quality_assessment.repositories.TestRepository;
import com.arranay.qualityassessment.quality_assessment.repositories.VerificationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TestService {

    private static DocumentRepository docRepository;
    private static VerificationRepository verRepository;
    private static TestRepository testRepository;

    public TestService(
            DocumentRepository newDocRepository,
            VerificationRepository newVerRepository,
            TestRepository newTestRepository
    ) {
        docRepository = newDocRepository;
        verRepository = newVerRepository;
        testRepository = newTestRepository;
    }

    public static void createTest(CreateTestModel createModel) {
        List<CreateDocumentModel> createDocumentModels = new ArrayList<>();
        createModel.getDocuments().forEach(model -> {
            DocumentItem doc = docRepository.findById(model.getId()).orElse(new DocumentItem());
            for (int i = 0; i < model.getCount(); i++) {
                createDocumentModels.add(new CreateDocumentModel(
                        doc.getName(),
                        doc.getValues(),
                        doc.getTemplateId(),
                        doc.getIssuerWalletId(),
                        doc.getOwnerWalletId(),
                        doc.getOwnerWalletConnectionId(),
                        doc.getIssuerWalletConnectionId()
                ));
            }
        });

        List<CreateVerificationModel> createVerificationModels = new ArrayList<>();
        createModel.getVerifications().forEach(model -> {
            VerificationItem ver = verRepository.findById(model.getId()).orElse(new VerificationItem());
            for (int i = 0; i < model.getCount(); i++) {
                createVerificationModels.add(new CreateVerificationModel(
                        ver.getName(),
                        ver.getDescription(),
                        ver.getAdditionalTemplates(),
                        ver.getVerificationFlowTemplates(),
                        ver.getHolderWalletId(),
                        ver.getHolderWalletConnectionId(),
                        ver.getVerifiedWithId(),
                        ver.getVerificationFlowId()
                ));
            }
        });

        List<DocumentModel> documentModelList = createDocuments(createDocumentModels);
        List<VerificationModel> verificationModelList = createVerifications(createVerificationModels);

        TestItem test = new TestItem(
                createModel.getName(),
                new Date(),
                documentModelList,
                verificationModelList
        );
        testRepository.save(test);
    }

    private static List<DocumentModel> createDocuments(List<CreateDocumentModel> createDocumentModels) {
        List<DocumentModel> createdDocuments = (List<DocumentModel>) DigitalDocumentManagementDocumentService
                .createDocuments(createDocumentModels)
                .collectList()
                .block();

        List<DocumentModel> documents = createdDocuments;
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

        return documents;
    }

    public static List<VerificationModel> createVerifications(List<CreateVerificationModel> createVerificationModels) {
        return (List<VerificationModel>) DigitalDocumentManagementVerificationService
                .sendVerifications(createVerificationModels)
                .collectList()
                .block();
    }
}
