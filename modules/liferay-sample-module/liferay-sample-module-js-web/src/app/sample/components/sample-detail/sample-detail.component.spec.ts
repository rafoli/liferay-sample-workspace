import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing'

import { SampleDetailComponent } from './sample-detail.component';

describe('SampleDetailComponent', () => {
  let component: SampleDetailComponent;
  let fixture: ComponentFixture<SampleDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule],
      declarations: [ SampleDetailComponent ]
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
