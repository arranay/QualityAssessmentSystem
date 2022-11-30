package com.arranay.qualityassessment.integration.models.auth;

public class DigitalDocumentManagementSystem {
    private DigitalDocumentManagementSystemState systemState;

    public DigitalDocumentManagementSystem() {}
    public DigitalDocumentManagementSystem(DigitalDocumentManagementSystemState state) {
        this.systemState = state;
    }

    public DigitalDocumentManagementSystemState getSystemState() { return this.systemState; }
    public void setSystemState(DigitalDocumentManagementSystemState systemState) { this.systemState = systemState; }
}