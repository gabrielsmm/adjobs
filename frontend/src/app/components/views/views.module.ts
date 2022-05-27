import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { EmpregosComponent } from './empregos/empregos.component';
import { MaterialModule } from './../../material.module';
import { CadastroRoutingModule } from './cadastro/cadastro-routing.module';
import { ComunsModule } from './../comuns/comuns.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { CadastroComponent } from './cadastro/cadastro.component';
import { EstagiosComponent } from './estagios/estagios.component';
import { ConcursosComponent } from './concursos/concursos.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NgxMaskModule } from 'ngx-mask';
import { CandidaturasComponent } from './candidaturas/candidaturas.component';

@NgModule({
  declarations: [
    CadastroComponent,
    EmpregosComponent,
    EstagiosComponent,
    ConcursosComponent,
    HomeComponent,
    LoginComponent,
    CandidaturasComponent
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
