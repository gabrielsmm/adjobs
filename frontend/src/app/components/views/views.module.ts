import { EmpregosComponent } from './empregos/empregos.component';
import { MaterialModule } from './../../material.module';
import { LoginRoutingModule } from './login/login-routing.module';
import { ComunsModule } from './../comuns/comuns.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { LoginComponent } from './login/login.component';
import { EstagiosComponent } from './estagios/estagios.component';
import { ConcursosComponent } from './concursos/concursos.component';

@NgModule({
  declarations: [
    LoginComponent,
    EmpregosComponent,
    EstagiosComponent,
    ConcursosComponent
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
