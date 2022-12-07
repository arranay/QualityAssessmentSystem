import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {LoginModel} from "../shared/models/login.model";
import {environment} from "../../environments/environment";
import {Observable, tap} from "rxjs";
import {UserModel} from "../shared/models/user.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(login: LoginModel): Observable<UserModel> {
    return this.http.post<UserModel>(`${environment.endPoint}/login`, login)
      .pipe(tap(this.setUserInfo.bind(this)))
  }

  setUserInfo(response: UserModel) {
    sessionStorage.setItem('systemState', response.systemState);
    sessionStorage.setItem('firstName', response.firstName);
    sessionStorage.setItem('lastName', response.lastName);
    sessionStorage.setItem('phoneNumber', response.phoneNumber);
    sessionStorage.setItem('icon', response.icon);
    sessionStorage.setItem('createdAt', response.createdAt);
    sessionStorage.setItem('email', response.email);
  }

  getUserInfo(): UserModel {
    const user: UserModel = {
      systemState: sessionStorage.getItem('systemState')!,
      firstName: sessionStorage.getItem('firstName')!,
      lastName: sessionStorage.getItem('lastName')!,
      phoneNumber: sessionStorage.getItem('phoneNumber')!,
      icon: sessionStorage.getItem('icon')!,
      createdAt: sessionStorage.getItem('createdAt')!,
      email: sessionStorage.getItem('email')!
    };

    return user;
  }
}
