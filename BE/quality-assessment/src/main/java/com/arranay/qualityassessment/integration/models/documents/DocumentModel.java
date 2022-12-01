package com.arranay.qualityassessment.integration.models.documents;

public class DocumentModel {
    private String _id;
    private String status;
    private String name;

    DocumentModel() {}
    DocumentModel(
            String _id,
            String status,
            String name
    ) {
        this._id = _id;
        this.status = status;
        this.name = name;
    }

    public String getName() { return this.name; }
    public String get_id() { return this._id; }
    public String getStatus() { return this.status; }

    public void setName(String name) { this.name = name; }
    public void set_id(String _id) { this._id = _id; }
    public void setStatus(String status) { this.status = status; }
}
