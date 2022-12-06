package com.arranay.qualityassessment.integration.models.verifications;

import java.util.Date;

public class VerificationModel {
    private String _id;
    private String name;
    private String description;
    private String status;
    private Date createdAt;

    public VerificationModel() {};
    public VerificationModel(
            String _id,
            String name,
            String description,
            String status,
            Date createdAt
    ) {
        this._id = _id;
        this.status = status;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    };

    public String get_id() { return this._id; }
    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
    public String getStatus() { return this.status; }
    public Date getCreatedAt() { return this.createdAt; }

    public void set_id(String _id) { this._id = _id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
