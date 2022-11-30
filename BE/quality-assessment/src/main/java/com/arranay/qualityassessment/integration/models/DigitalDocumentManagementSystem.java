package com.arranay.qualityassessment.integration.models;

public class DigitalDocumentManagementSystem {
    private SystemState systemState;

    public DigitalDocumentManagementSystem() {}
    public DigitalDocumentManagementSystem(SystemState state) {
        this.systemState = state;
    }

    public SystemState getSystemState() { return this.systemState; }
    public void setSystemState(SystemState systemState) { this.systemState = systemState; }
}