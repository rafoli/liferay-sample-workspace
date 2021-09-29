import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { RoleService } from 'src/app/auth/roles.service';
import { Sample } from "sample/model/sample";
import { SampleService } from "../../service/sample.service";
@Component({
  selector: 'app-sample-list',
  templateUrl: './sample-list.component.html',
  styleUrls: ['./sample-list.component.scss']
})
export class SampleListComponent implements OnInit {

  samples: Sample[] = []

  constructor(
    private _sampleService: SampleService,
    private router: Router,
    public roles: RoleService
  ) { }

  ngOnInit(): void {
    this.loadSamples()
  }

  loadSamples() {
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
