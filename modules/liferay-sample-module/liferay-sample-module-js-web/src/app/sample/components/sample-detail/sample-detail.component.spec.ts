import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing'

import { Sample } from 'sample/model/sample';

import { of } from 'rxjs';

import { SampleDetailComponent } from './sample-detail.component';
import { SampleService } from 'sample/service/sample.service';

describe('SampleDetailComponent', () => {
  let component: SampleDetailComponent;
  let fixture: ComponentFixture<SampleDetailComponent>;

  beforeEach(async () => {
    const sample: Sample = {
      id: '1',
      name: "Sample 1"
    };

    const sampleService = jasmine.createSpyObj('SampleService', ['getSample'])

    sampleService.getSample.and.returnValue(of(sample));

    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule],
      declarations: [ SampleDetailComponent ],
      providers: [{
        provide: SampleService,
        useValue: sampleService
      }]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SampleDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
