package com.arranay.qualityassessment.integration.models.verifications;

public class RuleModel {
    private String attributeName;
    private String method;
    private String value;
    private Boolean canEdit;

    public RuleModel() {}
    public RuleModel(
            String attributeName,
            String method,
            String value,
            Boolean canEdit
    ) {
        this.attributeName = attributeName;
        this.method = method;
        this.value = value;
        this.canEdit = canEdit;
    }

    public String getAttributeName() { return this.attributeName; }
    public String getMethod() { return this.method; }
    public String getValue() { return this.value; }
    public Boolean getCanEdit() { return this.canEdit; }

    public void setAttributeName(String attributeName) { this.attributeName = attributeName; }
    public void setMethod(String method) { this.method = method; }
    public void setValue(String value) { this.value = value; }
    public void setCanEdit(Boolean canEdit) { this.canEdit = canEdit; }
}
