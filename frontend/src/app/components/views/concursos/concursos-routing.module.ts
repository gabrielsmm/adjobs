import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ConcursosComponent } from './concursos.component';

const routes: Routes = [
  {path : '', component : ConcursosComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ConcursosRoutingModule { }
