package com.arranay.qualityassessment.quality_assessment.models.test;

import com.arranay.qualityassessment.integration.models.documents.DocumentModel;
import com.arranay.qualityassessment.integration.models.verifications.VerificationModel;

import java.util.Date;
import java.util.List;

public class TestView {
    private String id;
    private String name;
    private Date createAt;
    private Date finishAt;

    private List<DocumentModel> documents;
    private List<VerificationModel> verifications;

    private int documentsCount;
    private int verificationsCount;

    private int successDocumentsRate;
    private int successVerificationsRate;

    public TestView(
            String id,
            String name,
            Date createAt,
            Date finishAt,
            List<DocumentModel> documents,
            List<VerificationModel> verifications,
            int documentsCount,
            int verificationsCount,
            int successDocumentsRate,
            int successVerificationsRate)
    {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
        this.finishAt = finishAt;
        this.documents = documents;
        this.verifications = verifications;
        this.documentsCount = documentsCount;
        this.verificationsCount = verificationsCount;
        this.successDocumentsRate = successDocumentsRate;
        this.successVerificationsRate = successVerificationsRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(Date finishAt) {
        this.finishAt = finishAt;
    }

    public List<DocumentModel> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentModel> documents) {
        this.documents = documents;
    }

    public List<VerificationModel> getVerifications() {
        return verifications;
    }

    public void setVerifications(List<VerificationModel> verifications) {
        this.verifications = verifications;
    }

    public int getDocumentsCount() {
        return documentsCount;
    }

    public void setDocumentsCount(int documentsCount) {
        this.documentsCount = documentsCount;
    }

    public int getVerificationsCount() {
        return verificationsCount;
    }

    public void setVerificationsCount(int verificationsCount) {
        this.verificationsCount = verificationsCount;
    }

    public int getSuccessDocumentsRate() {
        return successDocumentsRate;
    }

    public void setSuccessDocumentsRate(int successDocumentsRate) {
        this.successDocumentsRate = successDocumentsRate;
    }

    public int getSuccessVerificationsRate() {
        return successVerificationsRate;
    }

    public void setSuccessVerificationsRate(int successVerificationsRate) {
        this.successVerificationsRate = successVerificationsRate;
    }
}
