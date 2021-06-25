import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SampleListComponent } from './components/sample-list/sample-list.component';
import {HttpClientModule} from "@angular/common/http";
import { SampleDetailComponent } from './components/sample-detail/sample-detail.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    SampleListComponent,
    SampleDetailComponent
  ],
  exports: [
    AppRoutingModule
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ]
})
export class SampleModule { }
