import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';

import { Sample } from 'sample/model/sample';

import { SampleCreateComponent } from './sample-create.component';
import { SampleService } from 'sample/service/sample.service';

describe('SampleCreateComponent', () => {
  let component: SampleCreateComponent;
  let fixture: ComponentFixture<SampleCreateComponent>;

  beforeEach(async () => {
    const sample: Sample = {
      id: '1',
      name: "Sample 1"
    };
    const sampleService = jasmine.createSpyObj('SampleService', ['getSample'])

    sampleService.getSample.and.returnValue(of(sample));

    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule],
      declarations: [ SampleCreateComponent ],
      providers: [
        {
          provide: SampleService,
          useValue: sampleService
        }
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SampleCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
