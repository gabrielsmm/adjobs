import { FormsModule } from '@angular/forms';
import { EmpregosComponent } from './empregos/empregos.component';
import { MaterialModule } from './../../material.module';
import { CadastroLoginRoutingModule } from './cadastro-login/cadastro-login-routing.module';
import { ComunsModule } from './../comuns/comuns.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { CadastroLoginComponent } from './cadastro-login/cadastro-login.component';
import { EstagiosComponent } from './estagios/estagios.component';
import { ConcursosComponent } from './concursos/concursos.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    CadastroLoginComponent,
    EmpregosComponent,
    EstagiosComponent,
    ConcursosComponent,
    HomeComponent
  ],
  imports: [
    CommonModule,
    ComunsModule,
    MaterialModule,
    FormsModule
  ],
  exports: [
    CadastroLoginRoutingModule
  ],
  providers: []
})
export class ViewsModule { }
