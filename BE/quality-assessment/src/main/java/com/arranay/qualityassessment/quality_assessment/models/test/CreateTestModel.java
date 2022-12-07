package com.arranay.qualityassessment.quality_assessment.models.test;

import java.util.ArrayList;

public class CreateTestModel {
    private String name;
    private ArrayList<TestItem> documents;
    private ArrayList<TestItem> verifications;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<TestItem> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<TestItem> documents) {
        this.documents = documents;
    }

    public ArrayList<TestItem> getVerifications() {
        return verifications;
    }

    public void setVerifications(ArrayList<TestItem> verifications) {
        this.verifications = verifications;
    }

    public CreateTestModel(String name, ArrayList<TestItem> documents, ArrayList<TestItem> verifications) {
        this.name = name;
        this.documents = documents;
        this.verifications = verifications;
    }
}
