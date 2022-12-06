package com.arranay.qualityassessment.integration.models.verifications;

import java.util.ArrayList;

public class TemplateModel {
    private String _id;
    private ArrayList<RuleModel> rules;

    public TemplateModel() {}
    public TemplateModel(
            String _id,
            ArrayList<RuleModel> rules
    ) {
        this._id = _id;
        this.rules = rules;
    }

    public String get_id() { return this._id; }
    public ArrayList<RuleModel> getRules() { return this.rules; }

    public void set_id(String _id) { this._id = _id; }
    public void setRules(ArrayList<RuleModel> rules) { this.rules = rules; }
}
