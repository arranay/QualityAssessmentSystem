export interface VerificationModel {
  id: string;
  name: string;
  description: string;
  additionalTemplates: TemplateModel;
  verificationFlowTemplates: TemplateModel;
  holderWalletId: string;
  holderWalletConnectionId: string;
  verifiedWithId: string;
  verificationFlowId: string;
}

export interface TemplateModel {
  _id: string;
  rules: RuleModel;
}

export interface RuleModel {
  attributeName: string;
  method: string;
  value: string;
  canEdit: boolean;
}
