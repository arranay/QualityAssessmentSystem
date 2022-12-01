package com.arranay.qualityassessment.integration.models.documents;

public class DocumentValues {
    private String name;
    private Object value;

    public DocumentValues() {}
    public DocumentValues(
            String name,
            Object value
    ) {
        this.name = name;
        this.value = value;
    }

    public String getName() { return this.name; }
    public Object getValue() { return  this.value; }

    public void setName(String name) { this.name = name; }
    public void setValue(Object value) { this.value = value; }
}
