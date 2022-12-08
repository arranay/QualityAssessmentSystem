import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { HttpClientModule } from '@angular/common/http';
import {ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { NewTestComponent } from './dashboard/new-test/new-test.component';
import {TooltipModule} from "ngx-bootstrap/tooltip";
import { NgxSpinnerModule } from 'ngx-spinner';
import { ModalModule, BsModalService } from 'ngx-bootstrap/modal';
import {NgxChartModule} from "ngx-chart";

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    DashboardComponent,
    NewTestComponent
  ],
  imports: [
    ToastrModule.forRoot(),
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgxSpinnerModule,
    ModalModule,
    TooltipModule.forRoot(),
    NgxChartModule,
    FormsModule
  ],
  providers: [BsModalService],
  bootstrap: [AppComponent]
})
export class AppModule { }
