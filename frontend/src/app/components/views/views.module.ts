import { MinhaAreaEmpresaComponent } from './area-empresa/minha-area/minha-area.component';
import { MinhaAreaCandidatoComponent } from './area-candidato/minha-area/minha-area.component';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MAT_DATE_LOCALE, MatNativeDateModule } from '@angular/material/core';
import { RouterModule } from '@angular/router';
import { NgxCurrencyModule } from 'ngx-currency';
import { NgxMaskModule } from 'ngx-mask';

import { MaterialModule } from './../../material.module';
import { ComunsModule } from './../comuns/comuns.module';
import { AreaCandidatoComponent } from './area-candidato/area-candidato.component';
import { CandidaturasComponent } from './area-candidato/candidaturas/candidaturas.component';
import { CurriculoComponent } from './area-candidato/curriculo/curriculo.component';
import { AreaEmpresaComponent } from './area-empresa/area-empresa.component';
import { VagasComponent } from './area-empresa/vagas/vagas.component';
import { CadastroRoutingModule } from './cadastro/cadastro-routing.module';
import { CadastroComponent } from './cadastro/cadastro.component';
import { ConcursosComponent } from './concursos/concursos.component';
import { EmpregosComponent } from './empregos/empregos.component';
import { EstagiosComponent } from './estagios/estagios.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { DadosEmpresaComponent } from './area-empresa/dados-empresa/dados-empresa.component';

@NgModule({
  declarations: [
    CadastroComponent,
    EmpregosComponent,
    EstagiosComponent,
    ConcursosComponent,
    HomeComponent,
    LoginComponent,
    AreaCandidatoComponent,
    MinhaAreaCandidatoComponent,
    MinhaAreaEmpresaComponent,
    CandidaturasComponent,
    CurriculoComponent,
    AreaEmpresaComponent,
    VagasComponent,
    DadosEmpresaComponent
  ],
  imports: [
    CommonModule,
    ComunsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    MatNativeDateModule,
    NgxCurrencyModule,
    NgxMaskModule.forRoot()
  ],
  exports: [
    CadastroRoutingModule
  ],
  providers: [
    {provide: MAT_DATE_LOCALE, useValue: 'pt-BR'},
  ]
})
export class ViewsModule { }
