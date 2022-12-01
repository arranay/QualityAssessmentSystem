import {Component, OnInit} from '@angular/core';
import {AuthService} from "../auth/auth.service";
import {UserModel} from "../shared/user.model";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.less']
})
export class DashboardComponent implements OnInit{
  public user: UserModel | null = null;

  constructor(
    private authService: AuthService
  ) {
  }

  ngOnInit(): void {
    this.user = this.authService.getUserInfo();
  }

}
