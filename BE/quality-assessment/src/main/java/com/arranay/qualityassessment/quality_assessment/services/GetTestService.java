package com.arranay.qualityassessment.quality_assessment.services;

import com.arranay.qualityassessment.integration.models.documents.DocumentModel;
import com.arranay.qualityassessment.integration.models.verifications.VerificationModel;
import com.arranay.qualityassessment.quality_assessment.db_models.TestItem;
import com.arranay.qualityassessment.quality_assessment.models.test.TestView;
import com.arranay.qualityassessment.quality_assessment.repositories.TestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GetTestService {
    private static TestRepository testRepository;

    public GetTestService(TestRepository newTestRepository) {
        testRepository = newTestRepository;
    }

    public static List<TestView> getAll() {
        List<TestItem> tests = testRepository.findAll();
        List<TestView> testViewList = new ArrayList<>();

        tests.forEach(test -> {
            int documentsCount = test.getDocuments().size();
            int verificationsCount = test.getVerifications().size();

            List<DocumentModel> doneDocuments = new ArrayList<>();
            test.getDocuments().forEach(doc -> {
                if (Objects.equals(doc.getStatus(), "done"))
                    doneDocuments.add(doc);
            });
            List<VerificationModel> successfulVerifications = new ArrayList<>();
            test.getVerifications().forEach(ver -> {
                if (Objects.equals(ver.getStatus(), "successful"))
                    successfulVerifications.add(ver);
            });

            int successDocumentsRate = doneDocuments.size() * 100 / documentsCount;
            int successVerificationsRate = successfulVerifications.size() * 100 / verificationsCount;

            testViewList.add(new TestView(
               test.getId(),
               test.getName(),
               test.getCreateAt(),
               test.getFinishAt(),
               test.getDocuments(),
               test.getVerifications(),
               documentsCount,
               verificationsCount,
               successDocumentsRate,
               successVerificationsRate
            ));
        });

        return testViewList;
    }
}
