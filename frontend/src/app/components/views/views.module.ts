import { EmpregosComponent } from './empregos/empregos.component';
import { MaterialModule } from './../../material.module';
import { LoginRoutingModule } from './login/login-routing.module';
import { ComunsModule } from './../comuns/comuns.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { LoginComponent } from './login/login.component';
import { EstagiosComponent } from './estagios/estagios.component';
import { ConcursosComponent } from './concursos/concursos.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    LoginComponent,
    EmpregosComponent,
    EstagiosComponent,
    ConcursosComponent,
    HomeComponent
  ],
  imports: [
    CommonModule,
    ComunsModule,
    MaterialModule
  ],
  exports: [
    LoginRoutingModule
  ],
  providers: []
})
export class ViewsModule { }
