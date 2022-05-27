import { AreaCandidatoComponent } from './area-candidato/area-candidato.component';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgxMaskModule } from 'ngx-mask';

import { MaterialModule } from './../../material.module';
import { ComunsModule } from './../comuns/comuns.module';
import { CadastroRoutingModule } from './cadastro/cadastro-routing.module';
import { CadastroComponent } from './cadastro/cadastro.component';
import { ConcursosComponent } from './concursos/concursos.component';
import { EmpregosComponent } from './empregos/empregos.component';
import { EstagiosComponent } from './estagios/estagios.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MinhaAreaComponent } from './area-candidato/minha-area/minha-area.component';
import { CandidaturasComponent } from './area-candidato/candidaturas/candidaturas.component';
import { CurriculoComponent } from './area-candidato/curriculo/curriculo.component';

@NgModule({
  declarations: [
    CadastroComponent,
    EmpregosComponent,
    EstagiosComponent,
    ConcursosComponent,
    HomeComponent,
    LoginComponent,
    AreaCandidatoComponent,
    MinhaAreaComponent,
    CandidaturasComponent,
    CurriculoComponent
  ],
  imports: [
    CommonModule,
    ComunsModule,
    MaterialModule,
    FormsModule,
    RouterModule,
    NgxMaskModule.forRoot()
  ],
  exports: [
    CadastroRoutingModule
  ],
  providers: []
})
export class ViewsModule { }
