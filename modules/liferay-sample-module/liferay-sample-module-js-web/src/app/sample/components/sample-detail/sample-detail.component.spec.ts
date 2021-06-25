import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SampleDetailComponent } from './sample-detail.component';

describe('SampleDetailComponent', () => {
  let component: SampleDetailComponent;
  let fixture: ComponentFixture<SampleDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
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
