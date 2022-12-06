package com.arranay.qualityassessment.quality_assessment.db_models;

import com.arranay.qualityassessment.integration.models.verifications.TemplateModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("verifications")
public class VerificationItem {
    @Id
    private String id;
    private String name;
    private String description;
    private ArrayList<TemplateModel> additionalTemplates;
    private ArrayList<TemplateModel> verificationFlowTemplates;
    private String holderWalletId;
    private String holderWalletConnectionId;
    private String verifiedWithId;
    private String verificationFlowId;

    public VerificationItem(
            String name,
            String description,
            ArrayList<TemplateModel> additionalTemplates,
            ArrayList<TemplateModel> verificationFlowTemplates,
            String holderWalletId,
            String holderWalletConnectionId,
            String verifiedWithId,
            String verificationFlowId)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.additionalTemplates = additionalTemplates;
        this.verificationFlowTemplates = verificationFlowTemplates;
        this.holderWalletId = holderWalletId;
        this.holderWalletConnectionId = holderWalletConnectionId;
        this.verifiedWithId = verifiedWithId;
        this.verificationFlowId = verificationFlowId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<TemplateModel> getAdditionalTemplates() {
        return additionalTemplates;
    }

    public void setAdditionalTemplates(ArrayList<TemplateModel> additionalTemplates) {
        this.additionalTemplates = additionalTemplates;
    }

    public ArrayList<TemplateModel> getVerificationFlowTemplates() {
        return verificationFlowTemplates;
    }

    public void setVerificationFlowTemplates(ArrayList<TemplateModel> verificationFlowTemplates) {
        this.verificationFlowTemplates = verificationFlowTemplates;
    }

    public String getHolderWalletId() {
        return holderWalletId;
    }

    public void setHolderWalletId(String holderWalletId) {
        this.holderWalletId = holderWalletId;
    }

    public String getHolderWalletConnectionId() {
        return holderWalletConnectionId;
    }

    public void setHolderWalletConnectionId(String holderWalletConnectionId) {
        this.holderWalletConnectionId = holderWalletConnectionId;
    }

    public String getVerifiedWithId() {
        return verifiedWithId;
    }

    public void setVerifiedWithId(String verifiedWithId) {
        this.verifiedWithId = verifiedWithId;
    }

    public String getVerificationFlowId() {
        return verificationFlowId;
    }

    public void setVerificationFlowId(String verificationFlowId) {
        this.verificationFlowId = verificationFlowId;
    }
}
