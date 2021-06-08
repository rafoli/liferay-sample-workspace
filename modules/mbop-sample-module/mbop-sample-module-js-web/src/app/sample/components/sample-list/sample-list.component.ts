import { Component, OnInit } from '@angular/core';
import {SampleService} from "../../service/sample.service";
import {Sample} from "sample/model/sample";
import {Observable} from "rxjs";

@Component({
  selector: 'app-sample-list',
  templateUrl: './sample-list.component.html',
  styleUrls: ['./sample-list.component.scss']
})
export class SampleListComponent implements OnInit {

  samples?: Observable<Sample[]>;

  constructor(private _sampleService: SampleService) { }

  ngOnInit(): void {
    this.samples = this._sampleService.getSamples()
  }

}
