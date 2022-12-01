import { Component } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {AuthService} from "./auth.service";
import {HttpErrorResponse} from "@angular/common/http";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.less']
})
export class AuthComponent {

  form = this.fb.group({
    login: [null, Validators.required],
    password: [null, Validators.required],
  });

  constructor(
    private fb: FormBuilder,
    private toastr: ToastrService,
    private authService: AuthService,
    private route: Router
  ) {
  }

  submit() {
    this.form.markAsTouched()
    if (this.form.valid) this.authService.login(this.form.getRawValue())
      .subscribe(
        () => this.route.navigateByUrl('dashboard'),
        error => this.handlerError(error)
      )
  }

  handlerError(error: HttpErrorResponse) {
    this.toastr.error(error.error.message);
  }
}
