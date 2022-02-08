import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpregosComponent } from './empregos.component';

const routes: Routes = [
  {path : '', component : EmpregosComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmpregosRoutingModule { }
