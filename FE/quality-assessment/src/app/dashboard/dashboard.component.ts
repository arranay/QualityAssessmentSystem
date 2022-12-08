import {Component, OnInit} from '@angular/core';
import {AuthService} from "../auth/auth.service";
import {UserModel} from "../shared/models/user.model";
import {DashboardService} from "./dashboard.service";
import { BsModalService } from 'ngx-bootstrap/modal';
import {NewTestComponent} from "./new-test/new-test.component";
import {DocStatus, Test, VerStatus} from "../shared/models/test.model";
import {HttpErrorResponse} from "@angular/common/http";
import {ToastrService} from "ngx-toastr";
import {NgxSpinnerService} from "ngx-spinner";
import {finalize} from "rxjs";
import {ChartData, ChartOption, DonutChartView} from "ngx-chart";

const VerColor = {
  [VerStatus.Declined]: "#483d8b",
  [VerStatus.Error]: "#FF0000",
  [VerStatus.Successful]: "#008000",
  [VerStatus.Unsuccessful]: "#FFFF00",
  [VerStatus.RequestSent]: "#8fbc8f",
  [VerStatus.RequestReceived]: "#1e90ff",
  [VerStatus.TimeoutExpired]: "#cd5c5c",
  [VerStatus.PresentationSent]: "#e0ffff",
  [VerStatus.PresentationReceived]: "#ba55d3",
  [VerStatus.ProposalSent]: "#2f4f4f",
  [VerStatus.ProposalReceived]: "#cd5c5c",
}

const DocColor = {
  [DocStatus.Done]: "#008000",
  [DocStatus.CredentialIssued]: "#8fbc8f",
  [DocStatus.Error]: "#FF0000",
  [DocStatus.Draft]: "#FFFF00",
  [DocStatus.Declined]: "#483d8b",
  [DocStatus.OfferReceived]: "#2f4f4f",
  [DocStatus.ProposalReceived]: "#9400d3",
  [DocStatus.ProposalSent]: "#ff1493",
  [DocStatus.OfferSent]: "#1e90ff",
  [DocStatus.RequestReceived]: "#ff69b4",
  [DocStatus.RequestSent]: "#cd5c5c",
  [DocStatus.CredentialReceived]: "#e0ffff",
  [DocStatus.TimeoutExpired]: "#20b2aa",
  [DocStatus.Revoked]: "#ba55d3",
}

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.less']
})
export class DashboardComponent implements OnInit{
  public user: UserModel | null = null;
  public tests: Test[] = [];
  testId: string = '';

  verificationsChartData: ChartData[] = [];
  documentsChartData: ChartData[] = [];

  pieView: DonutChartView = {
    height: 150,
    width: 150,
    radius: 50,
    donutSize: 15
  }
  chartOptions: ChartOption = {
    showLegend: false,
    legendTitle: 'Total',
  }

  constructor(
    private authService: AuthService,
    private dashboardService: DashboardService,
    private modalService: BsModalService,
    private toastr: ToastrService,
    private spinner: NgxSpinnerService
  ) {
  }

  ngOnInit(): void {
    this.user = this.authService.getUserInfo();
    this.loadTests();
  }

  start() {
    const modal = this.modalService.show(NewTestComponent, { class: 'modal-lg' });
    modal.content?.close.subscribe(this.loadTests.bind(this))
  }

  private loadTests() {
    this.spinner.show("tests");
    this.dashboardService.getAllTests()
      .pipe(finalize(() => this.spinner.hide("tests")))
      .subscribe(
      tests => {
        this.tests = tests;
        this.change(tests[0].id);
      },
      error => this.handlerError(error)
    )
  }

  handlerError(error: HttpErrorResponse) {
    this.toastr.error(error.error.message);
  }

  getTest() {
    return this.tests.find(test => test.id === this.testId);
  }

  change(id: string) {
    this.testId = id;
    const test = this.getTest();

    if (!test) return;

    this.verificationsChartData = Object.values(VerStatus).map((status, i) => ({
      name: status,
      value: test.verifications.filter((test: any) => test.status === status).length,
      color: VerColor[status]
    }));
    this.documentsChartData = Object.values(DocStatus).map((status, i) => ({
      name: status,
      value: test.documents.filter((test: any) => test.status === status).length,
      color: DocColor[status]
    }));
  }
}
