import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {
  RoleAdminService as RoleAdmin,
} from '../auth/role-admin.service';

import {
  RoleSignedService as RoleSigned
} from '../auth/role-signed.service';

import { SampleDetailComponent } from './components/sample-detail/sample-detail.component'
import { SampleListComponent } from './components/sample-list/sample-list.component'
import { SampleCreateComponent } from './components/sample-create/sample-create.component'


const routes: Routes = [
  {
    path: "",
    component: SampleListComponent
  },
  {
    path: "create",
    component: SampleCreateComponent,
    canActivate: [RoleAdmin]
  },
  {
    path: "details/:id",
    component: SampleDetailComponent
  },
]

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule],
  providers: [RoleAdmin, RoleSigned]
})
export class AppRoutingModule { }
