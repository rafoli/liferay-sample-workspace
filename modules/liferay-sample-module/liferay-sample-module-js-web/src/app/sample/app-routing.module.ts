import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SampleDetailComponent } from './components/sample-detail/sample-detail.component'
import { SampleListComponent } from './components/sample-list/sample-list.component'

const routes: Routes = [
  {path: "", component: SampleListComponent},
  {path: "details/:id", component: SampleDetailComponent},
]

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
