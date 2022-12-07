export interface DocumentModel {
  id: string;
  name: string;
  values: DocumentValues;
  templateId: string;
  issuerWalletId: string;
  ownerWalletId: string;
  ownerWalletConnectionId: string;
  issuerWalletConnectionId: string;
}

export interface DocumentValues {
  name: string;
  value: string;
}
