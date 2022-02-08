import { MaterialModule } from './../../material.module';
import { LoginRoutingModule } from './login/login-routing.module';
import { ComunsModule } from './../comuns/comuns.module';
import { PaginaPrincipalRoutingModule } from './pagina-principal/pagina-principal-routing.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { PaginaPrincipalComponent } from './pagina-principal/pagina-principal.component';
import { LoginComponent } from './login/login.component';
import { EmpregosComponent } from './empregos/empregos.component';
import { EstagiosComponent } from './estagios/estagios.component';
import { ConcursosComponent } from './concursos/concursos.component';

@NgModule({
  declarations: [
    PaginaPrincipalComponent,
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
    PaginaPrincipalRoutingModule,
    LoginRoutingModule
  ],
  providers: []
})
export class ViewsModule { }
