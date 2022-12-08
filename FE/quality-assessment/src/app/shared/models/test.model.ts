import {VerificationModel} from "./verification.model";
import {DocumentModel} from "./document.model";

export interface CreateTestModel {
  name: string,
  documents: TestItem[],
  verifications: TestItem[]
}

export interface TestItem {
  id: string | null,
  count: number | null
}

export interface Test {
  id: string;
  name: string,
  createAt: Date,
  finishAt: Date,
  documents: Document[],
  verifications: Verification[]

  documentsCount: number;
  verificationsCount: number;

  successDocumentsRate: number;
  successVerificationsRate: number;
}

export interface Document {
  id: string,
  name: string;
  status: DocStatus;
}

export enum DocStatus {
  Draft = 'draft',
  ProposalSent = 'proposal-sent',
  ProposalReceived = 'proposal-received',
  OfferSent = 'offer-sent',
  OfferReceived = 'offer-received',
  Declined = 'declined',
  RequestSent = 'request-sent',
  RequestReceived = 'request-received',
  CredentialIssued = 'credential-issued',
  CredentialReceived = 'credential-received',
  TimeoutExpired = 'timeout-expired',
  Done = 'done',
  Error = 'error',
  Revoked = 'revoked'
}

export interface Verification {
  id: string,
  name: string;
  status: VerStatus;
}

export enum VerStatus {
  ProposalSent = 'proposal-sent',
  ProposalReceived = 'proposal-received',
  RequestSent = 'request-sent',
  RequestReceived = 'request-received',
  PresentationSent = 'presentation-sent',
  PresentationReceived = 'presentation-received',
  Declined = 'declined',
  Error = 'error',
  Successful = 'successful',
  Unsuccessful = 'unsuccessful',
  TimeoutExpired = 'timeout-expired'
}
