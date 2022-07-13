import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AreaCandidatoComponent } from './area-candidato.component';
import { CandidaturasComponent } from './candidaturas/candidaturas.component';
import { CurriculoComponent } from './curriculo/curriculo.component';
import { MinhaAreaCandidatoComponent } from './minha-area/minha-area.component';

const routes: Routes = [
  {path : '', component : AreaCandidatoComponent, children: [
    {path: 'area', component: MinhaAreaCandidatoComponent},
    {path: 'candidaturas', component: CandidaturasComponent},
    {path: 'curriculo', component: CurriculoComponent},
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AreaCandidatoRoutingModule { }
