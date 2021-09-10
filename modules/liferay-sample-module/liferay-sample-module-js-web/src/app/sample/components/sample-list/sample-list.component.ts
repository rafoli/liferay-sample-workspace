import { Component, OnInit } from '@angular/core';
import {SampleService} from "../../service/sample.service";
import {Sample} from "sample/model/sample";
import {Observable} from "rxjs";
import { Router } from '@angular/router';
@Component({
  selector: 'app-sample-list',
  templateUrl: './sample-list.component.html',
  styleUrls: ['./sample-list.component.scss']
})
export class SampleListComponent implements OnInit {

  samples: Sample[] = []

  constructor(private _sampleService: SampleService, private router: Router) { }

  ngOnInit(): void {
    this._sampleService.getSamples().subscribe(res => {
      this.samples = res.items
    })
  }
  create() {
    this.router.navigateByUrl("create", {skipLocationChange: true});
  }

  delete(id: string) {
    if (id) {
      this._sampleService.deleteSample(Number(id))
        .subscribe(()=>{});
    }
  }
}
