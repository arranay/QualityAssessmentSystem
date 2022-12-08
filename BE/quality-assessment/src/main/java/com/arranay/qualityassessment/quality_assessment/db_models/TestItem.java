package com.arranay.qualityassessment.quality_assessment.db_models;

import com.arranay.qualityassessment.integration.models.documents.DocumentModel;
import com.arranay.qualityassessment.integration.models.verifications.VerificationModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("tests")
public class TestItem {
    @Id
    private String id;

    private String name;
    private Date createAt;

    private List<DocumentModel> documents;
    private List<VerificationModel> verifications;

    public TestItem(
            String name,
            Date createAt,
            List<DocumentModel> documents,
            List<VerificationModel> verifications)
    {
        this.name = name;
        this.createAt = createAt;
        this.documents = documents;
        this.verifications = verifications;
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
}
