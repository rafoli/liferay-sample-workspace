import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {SampleModule} from "sample/sample.module";
import { AppRoutingModule } from './app-routing.module';
import { SampleDetailComponent } from './sample/components/sample-detail/sample-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    SampleDetailComponent
  ],
  imports: [
    BrowserModule,
    SampleModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
