package com.arranay.qualityassessment.integration.models.documents;

import java.util.HashMap;
import java.util.Map;

public enum DocumentStatus {
    DRAFT("draft"),
    PROPOSAL_SENT("proposal-sent"),
    PROPOSAL_RECEIVED("proposal-received"),
    OFFER_SENT("offer-sent"),
    OFFER_RECEIVED("offer-received"),
    DECLINED("declined"),
    REQUEST_SENT("request-sent"),
    REQUEST_RECEIVED("request-received"),
    CREDENTIAL_ISSUED("credential-issued"),
    CREDENTIAL_RECEIVED("credential-received"),
    DONE("done"),
    REVOKED("revoked"),
    ERROR("error"),
    TIMEOUT_EXPIRED("timeout-expired");

    private final String abbreviation;
    private static final Map<String, DocumentStatus> lookup = new HashMap<String, DocumentStatus>();

    static {
        for (DocumentStatus d : DocumentStatus.values()) {
            lookup.put(d.getAbbreviation(), d);
        }
    }

    private DocumentStatus(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static DocumentStatus get(String abbreviation) {
        return lookup.get(abbreviation);
    }
}
