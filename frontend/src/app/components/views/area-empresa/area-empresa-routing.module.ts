import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MinhaAreaEmpresaComponent } from './../area-empresa/minha-area/minha-area.component';
import { AreaEmpresaComponent } from './area-empresa.component';
import { VagasComponent } from './vagas/vagas.component';

const routes: Routes = [
  {path : '', component : AreaEmpresaComponent, children: [
    {path: 'area', component: MinhaAreaEmpresaComponent},
    {path: 'vagas', component: VagasComponent},
    // {path: 'curriculo', component: CurriculoComponent},
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AreaEmpresaRoutingModule { }
