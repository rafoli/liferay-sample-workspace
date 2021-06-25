import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SampleService } from '../../service/sample.service'
@Component({
  selector: 'app-sample-create',
  templateUrl: './sample-create.component.html',
  styleUrls: ['./sample-create.component.scss']
})
export class SampleCreateComponent implements OnInit {
  sampleName: string = "";
  constructor(private router: Router, private sampleService: SampleService) { }
  ngOnInit(): void {
  }

  goBack() {
    this.router.navigateByUrl("", {skipLocationChange: true});
  }

  create() {
    this.sampleService.createSample(this.sampleName)
      .subscribe(()=>this.goBack());
  }
}
