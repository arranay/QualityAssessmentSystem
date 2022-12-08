import {Component, OnInit} from '@angular/core';
import {DashboardService} from "../dashboard.service";
import {DocumentModel} from "../../shared/models/document.model";
import {VerificationModel} from "../../shared/models/verification.model";
import {BsModalRef} from "ngx-bootstrap/modal";
import {NgxSpinnerService} from "ngx-spinner";
import {FormBuilder, Validators} from "@angular/forms";
import {CreateTestModel} from "../../shared/models/test.model";
import {finalize} from "rxjs";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-new-test',
  templateUrl: './new-test.component.html',
  styleUrls: ['./new-test.component.less']
})
export class NewTestComponent implements OnInit {
  documents: DocumentModel[] = [];
  verifications: VerificationModel[] = [];

  documentsForm = this.fb.array([this.fb.group({
    id: [null, Validators.required],
    count: [null, Validators.required],
  })]);
  verificationsForm = this.fb.array([this.fb.group({
    id: [null, Validators.required],
    count: [null, Validators.required],
  })]);

  form = this.fb.group({
    name: [null, Validators.required],
    documentsForm: this.documentsForm,
    verificationsForm: this.verificationsForm,
  });

  constructor(
    private dashboardService: DashboardService,
    private spinner: NgxSpinnerService,
    public bsModalRef: BsModalRef,
    private fb: FormBuilder,
    private toastrService: ToastrService
  ) {}

  ngOnInit(): void {
    this.loadInfo();
  }

  async loadInfo() {
    await this.spinner.show('test')
    const [documents, verifications] = await Promise.all([
      this.dashboardService.getDocuments().toPromise(),
      this.dashboardService.getVerifications().toPromise()
    ])

    this.documents = documents || [];
    this.verifications = verifications || [];

    await this.spinner.hide('test')
  }

  async start() {
    if (this.form.valid) {
      await this.spinner.show('test');
      const test = this.form.getRawValue();
      this.dashboardService.createTest({
        name: test.name!,
        documents: test.documentsForm.filter(doc => doc.id && doc.count),
        verifications: test.verificationsForm.filter(doc => doc.id && doc.count)
      })
        .pipe(finalize(() => this.spinner.hide('test')))
        .subscribe(
          () => this.bsModalRef.hide(),
          error => this.toastrService.error(error.message)
        );
    }
  }

  addDoc() {
    this.documentsForm.push(this.fb.group({
      id: [null, Validators.required],
      count: [null, Validators.required],
    }));
  }

  addVer() {
    this.verificationsForm.push(this.fb.group({
      id: [null, Validators.required],
      count: [null, Validators.required],
    }));
  }

  deleteDocument(i: number) {
    this.documentsForm.removeAt(i)
  }

  deleteVerification(i: number) {
    this.verificationsForm.removeAt(i)
  }
}
