import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SampleListComponent } from './components/sample-list/sample-list.component';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    SampleListComponent
  ],
  exports: [
    SampleListComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule
  ]
})
export class SampleModule { }
