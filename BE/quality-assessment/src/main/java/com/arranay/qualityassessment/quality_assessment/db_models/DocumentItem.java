package com.arranay.qualityassessment.quality_assessment.db_models;

import com.arranay.qualityassessment.integration.models.documents.DocumentValues;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("documents")
public class DocumentItem {
    @Id
    private String id;

    private String name;
    private ArrayList<DocumentValues> values;
    private String templateId;
    private String issuerWalletId;
    private String ownerWalletId;
    private String ownerWalletConnectionId;
    private String issuerWalletConnectionId;

    public DocumentItem() {}
    public DocumentItem(
            String name,
            ArrayList<DocumentValues> values,
            String templateId,
            String issuerWalletId,
            String ownerWalletId,
            String ownerWalletConnectionId,
            String issuerWalletConnectionId)
    {
        this.id = id;
        this.name = name;
        this.values = values;
        this.templateId = templateId;
        this.issuerWalletId = issuerWalletId;
        this.ownerWalletId = ownerWalletId;
        this.ownerWalletConnectionId = ownerWalletConnectionId;
        this.issuerWalletConnectionId = issuerWalletConnectionId;
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

    public ArrayList<DocumentValues> getValues() {
        return values;
    }

    public void setValues(ArrayList<DocumentValues> values) {
        this.values = values;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getIssuerWalletId() {
        return issuerWalletId;
    }

    public void setIssuerWalletId(String issuerWalletId) {
        this.issuerWalletId = issuerWalletId;
    }

    public String getOwnerWalletId() {
        return ownerWalletId;
    }

    public void setOwnerWalletId(String ownerWalletId) {
        this.ownerWalletId = ownerWalletId;
    }

    public String getOwnerWalletConnectionId() {
        return ownerWalletConnectionId;
    }

    public void setOwnerWalletConnectionId(String ownerWalletConnectionId) {
        this.ownerWalletConnectionId = ownerWalletConnectionId;
    }

    public String getIssuerWalletConnectionId() {
        return issuerWalletConnectionId;
    }

    public void setIssuerWalletConnectionId(String issuerWalletConnectionId) {
        this.issuerWalletConnectionId = issuerWalletConnectionId;
    }
}
