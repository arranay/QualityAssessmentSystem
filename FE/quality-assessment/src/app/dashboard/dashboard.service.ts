import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from "../../environments/environment";
import { Observable } from "rxjs";
import { DocumentModel } from "../shared/models/document.model";
import { VerificationModel } from "../shared/models/verification.model";
import { CreateTestModel, Test } from "../shared/models/test.model";

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(
    private http: HttpClient
  ) { }

  getDocuments(): Observable<DocumentModel[]> {
    return this.http.get<DocumentModel[]>(`${environment.endPoint}/documents`);
  }

  getVerifications(): Observable<VerificationModel[]> {
    return this.http.get<VerificationModel[]>(`${environment.endPoint}/verifications`);
  }

  createTest(test: CreateTestModel): Observable<Test> {
    return this.http.post<Test>(`${environment.endPoint}/test`, test);
  }

  getAllTests(): Observable<any> {
    return this.http.get<any>(`${environment.endPoint}/test`);
  }
}
