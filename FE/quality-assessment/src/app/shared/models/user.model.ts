export interface UserModel{
  systemState: SystemState | string;
  firstName: string;
  lastName: string;
  phoneNumber: string;
  icon: string;
  createdAt: string;
  email: string;
}

export enum SystemState {
  OFFER_ACTIVATE = 'OFFER_ACTIVATE',
  ACTIVE = 'ACTIVE',
  INACTIVE = 'INACTIVE'
}
