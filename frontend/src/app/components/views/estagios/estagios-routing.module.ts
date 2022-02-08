import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EstagiosComponent } from './estagios.component';

const routes: Routes = [
  {path : '', component : EstagiosComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EstagiosRoutingModule { }
