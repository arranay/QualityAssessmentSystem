package com.arranay.qualityassessment.integration.models.verifications;

import java.util.ArrayList;

public class CreateVerificationModel {
    private String name;
    private String description;
    private ArrayList<TemplateModel> additionalTemplates;
    private ArrayList<TemplateModel> verificationFlowTemplates;
    private String holderWalletId;
    private String holderWalletConnectionId;
    private String verifiedWithId;
    private String verificationFlowId;

    public CreateVerificationModel() {}
    public CreateVerificationModel(
            String name,
            String description,
            ArrayList<TemplateModel> additionalTemplates,
            ArrayList<TemplateModel> verificationFlowTemplates,
            String holderWalletId,
            String holderWalletConnectionId,
            String verifiedWithId,
            String verificationFlowId
    ) {
        this.name = name;
        this.description = description;
        this.additionalTemplates = additionalTemplates;
        this.verificationFlowId = verificationFlowId;
        this.verificationFlowTemplates = verificationFlowTemplates;
        this.holderWalletId = holderWalletId;
        this.holderWalletConnectionId = holderWalletConnectionId;
        this.verifiedWithId = verifiedWithId;
    }

    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
    public String getHolderWalletId() { return this.holderWalletId; }
    public String getHolderWalletConnectionId() { return this.holderWalletConnectionId; }
    public String getVerifiedWithId() { return this.verifiedWithId; }
    public String getVerificationFlowId() { return this.verificationFlowId; }
    public ArrayList<TemplateModel> getAdditionalTemplates() { return this.additionalTemplates; }
    public ArrayList<TemplateModel> getVerificationFlowTemplates() { return this.verificationFlowTemplates; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setHolderWalletId(String holderWalletId) { this.holderWalletId = holderWalletId; }
    public void setHolderWalletConnectionId(String holderWalletConnectionId) { this.holderWalletConnectionId = holderWalletConnectionId; }
    public void setVerifiedWithId(String verifiedWithId) { this.verifiedWithId = verifiedWithId; }
    public void setVerificationFlowId(String verificationFlowId) { this.verificationFlowId = verificationFlowId; }
    public void setAdditionalTemplates(ArrayList<TemplateModel> additionalTemplates) { this.additionalTemplates = additionalTemplates; }
    public void setVerificationFlowTemplates(ArrayList<TemplateModel> verificationFlowTemplates) { this.verificationFlowTemplates = verificationFlowTemplates; }
}
