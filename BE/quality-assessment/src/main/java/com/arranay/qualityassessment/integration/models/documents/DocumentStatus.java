package com.arranay.qualityassessment.integration.models.documents;

public enum DocumentStatus {
    DRAFT(0, "draft"),
    PROPOSAL_SENT(1, "proposal-sent"),
    PROPOSAL_RECEIVED(2, "proposal-received"),
    OFFER_SENT(3, "offer-sent"),
    OFFER_RECEIVED(4, "offer-received"),
    DECLINED(5, "declined"),
    REQUEST_SENT(6, "request-sent"),
    REQUEST_RECEIVED(7, "request-received"),
    CREDENTIAL_ISSUED(8, "credential-issued"),
    CREDENTIAL_RECEIVED(9, "credential-received"),
    DONE(10, "done"),
    REVOKED(11, "revoked"),
    ERROR(12, "error"),
    TIMEOUT_EXPIRED(13, "timeout-expired");

    private int key;
    private String value;

    DocumentStatus(int key, String value){
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return this.value;
    }
    // TODO fromString
}
