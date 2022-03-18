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

@NgModule({
  declarations: [
    CadastroComponent,
    EmpregosComponent,
    EstagiosComponent,
    ConcursosComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    ComunsModule,
    MaterialModule,
    FormsModule
  ],
  exports: [
    CadastroRoutingModule
  ],
  providers: []
})
export class ViewsModule { }
