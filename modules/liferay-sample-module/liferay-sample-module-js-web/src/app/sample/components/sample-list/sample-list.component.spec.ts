import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing'

import { Sample } from 'sample/model/sample';

import { of } from 'rxjs';

import { RoleService } from 'src/app/auth/roles.service';
import { SampleService } from 'sample/service/sample.service';
import { SampleListComponent } from './sample-list.component';

describe('SampleListComponent', () => {
  let component: SampleListComponent;
  let fixture: ComponentFixture<SampleListComponent>;

  beforeEach(async () => {
    const samples: Sample[] = [
      {
        id: '1',
        name: "Sample 1"
      },
      {
        id: '2',
        name: "Sample 2"
      },
      {
        id: '3',
        name: "Sample 3"
      },
    ]

    const sampleService = jasmine.createSpyObj('SampleService', ['getSamples'])

    sampleService.getSamples.and.returnValue(of({items: samples}));

    const roleService = jasmine.createSpyObj('RoleService', ['isSignedIn', 'isAdmin'])

    roleService.isSignedIn.and.returnValue(true)
    roleService.isAdmin.and.returnValue(true)

    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule],
      declarations: [SampleListComponent],
      providers: [
        {
          provide: SampleService,
          useValue: sampleService
        },
        {
          provide: RoleService,
          useValue: roleService
        }
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SampleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    expect(component.samples.length).toBe(3)
  });
});
