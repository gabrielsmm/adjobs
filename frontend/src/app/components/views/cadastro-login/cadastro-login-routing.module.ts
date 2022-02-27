import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CadastroLoginComponent } from './cadastro-login.component';

const routes: Routes = [
  {path : '', component : CadastroLoginComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CadastroLoginRoutingModule { }
