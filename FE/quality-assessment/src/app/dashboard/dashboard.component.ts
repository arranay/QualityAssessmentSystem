import {Component, OnInit} from '@angular/core';
import {AuthService} from "../auth/auth.service";
import {UserModel} from "../shared/models/user.model";
import {DashboardService} from "./dashboard.service";
import { BsModalService } from 'ngx-bootstrap/modal';
import {NewTestComponent} from "./new-test/new-test.component";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.less']
})
export class DashboardComponent implements OnInit{
  public user: UserModel | null = null;

  constructor(
    private authService: AuthService,
    private dashboardService: DashboardService,
    private modalService: BsModalService,
  ) {
  }

  ngOnInit(): void {
    this.user = this.authService.getUserInfo();
  }

  start() {
    this.modalService.show(NewTestComponent, { class: 'modal-lg' });
  }
}
