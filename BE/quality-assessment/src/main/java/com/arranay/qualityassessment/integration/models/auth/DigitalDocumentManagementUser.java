package com.arranay.qualityassessment.integration.models.auth;

public class DigitalDocumentManagementUser {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String icon;
    private String createdAt;
    private String email;

    public DigitalDocumentManagementUser() {}
    public DigitalDocumentManagementUser(
            String firstName,
            String lastName,
            String phoneNumber,
            String icon,
            String createdAt,
            String email
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.icon = icon;
        this.email = email;
        this.createdAt = createdAt;
    }

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getPhoneNumber() { return this.phoneNumber; }
    public String getIcon() { return this.icon; }
    public String getEmail() { return this.email; }
    public String getCreatedAt() { return this.createdAt; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setIcon(String icon) { this.icon = icon; }
    public void setEmail(String email) { this.email = email; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
