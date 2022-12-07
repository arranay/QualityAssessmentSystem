package com.arranay.qualityassessment.quality_assessment.models.auth;

import com.arranay.qualityassessment.integration.models.auth.DigitalDocumentManagementSystemState;

public class User {
    private DigitalDocumentManagementSystemState systemState;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String icon;
    private String createdAt;
    private String email;

    public User() {}

    public User(
            String firstName,
            String lastName,
            String phoneNumber,
            String icon,
            String createdAt,
            String email,
            DigitalDocumentManagementSystemState state
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.icon = icon;
        this.email = email;
        this.createdAt = createdAt;
        this.systemState = state;
    }

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getPhoneNumber() { return this.phoneNumber; }
    public String getIcon() { return this.icon; }
    public String getEmail() { return this.email; }
    public String getCreatedAt() { return this.createdAt; }
    public DigitalDocumentManagementSystemState getSystemState() { return this.systemState; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setIcon(String icon) { this.icon = icon; }
    public void setEmail(String email) { this.email = email; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public void setSystemState(DigitalDocumentManagementSystemState systemState) { this.systemState = systemState; }
}
