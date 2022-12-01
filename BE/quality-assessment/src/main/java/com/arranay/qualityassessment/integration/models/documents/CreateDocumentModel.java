package com.arranay.qualityassessment.integration.models.documents;

import java.util.ArrayList;

public class CreateDocumentModel {
    private String name;
    private ArrayList<DocumentValues> values;
    private String templateId;
    private String issuerWalletId;
    private String ownerWalletId;
    private String ownerWalletConnectionId;
    private String issuerWalletConnectionId;


    public CreateDocumentModel() {}
    public CreateDocumentModel(
            String name,
            ArrayList<DocumentValues> values,
            String templateId,
            String issuerWalletId,
            String ownerWalletId,
            String ownerWalletConnectionId,
            String issuerWalletConnectionId
    ) {
        this.name = name;
        this.values = values;
        this.templateId = templateId;
        this.issuerWalletId = issuerWalletId;
        this.ownerWalletId = ownerWalletId;
        this.ownerWalletConnectionId = ownerWalletConnectionId;
        this.issuerWalletConnectionId = issuerWalletConnectionId;
    }

    public String getName() { return this.name; }
    public ArrayList<DocumentValues> getValues() { return this.values; }
    public String getTemplateId() { return this.templateId; }
    public String getIssuerWalletId() { return this.issuerWalletId; }
    public String getOwnerWalletId() { return this.ownerWalletId; }
    public String getOwnerWalletConnectionId() { return this.ownerWalletConnectionId; }
    public String getIssuerWalletConnectionId() { return this.issuerWalletConnectionId; }

    public void setName(String name) { this.name = name; }
    public void setValues(ArrayList<DocumentValues> values) { this.values = values; }
    public void setTemplateId(String templateId) { this.templateId = templateId; }
    public void setIssuerWalletId(String issuerWalletId) { this.issuerWalletId = issuerWalletId; }
    public void setOwnerWalletId(String ownerWalletId) { this.ownerWalletId = ownerWalletId; }
    public void setOwnerWalletConnectionId(String ownerWalletConnectionId) { this.ownerWalletConnectionId = ownerWalletConnectionId; }
    public void setIssuerWalletConnectionId(String issuerWalletConnectionId) { this.issuerWalletConnectionId = issuerWalletConnectionId; }
}
