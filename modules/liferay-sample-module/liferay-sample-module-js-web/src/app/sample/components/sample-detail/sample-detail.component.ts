import { Component, Input, OnInit, } from '@angular/core';
import { Observable } from 'rxjs';
import {Sample} from "sample/model/sample";
import {SampleService} from "../../service/sample.service";
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-sample-detail',
  templateUrl: './sample-detail.component.html',
  styleUrls: ['./sample-detail.component.scss']
})
export class SampleDetailComponent implements OnInit {
  @Input() sample?: Sample;

  constructor(private sampleService: SampleService, private route: ActivatedRoute, private location: Location, private router: Router) { }

  ngOnInit(): void {
    this.getSample();
  }

  goBack(): void {
    this.router.navigateByUrl("", {skipLocationChange: true})
  }

  getSample() {
    const id = Number(this.route.snapshot.paramMap.get('id'))
    this.sampleService.getSample(id)
      .subscribe(sample=>this.sample=sample)
  }

  save() {
    if (this.sample) {
      this.sampleService.updateSample(this.sample)
        .subscribe(()=>this.goBack());
    }
  }

}
