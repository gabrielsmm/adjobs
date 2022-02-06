import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { PaginaPrincipalComponent } from './pagina-principal/pagina-principal.component';

@NgModule({
  declarations: [
    PaginaPrincipalComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    PaginaPrincipalComponent
  ],
  providers: []
})
export class ViewsModule { }
