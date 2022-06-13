import { NgxMaskModule } from 'ngx-mask';
import { DialogCurriculoComponent } from './dialog-curriculo/dialog-curriculo.component';
import { MaterialModule } from './../../material.module';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { DialogComponent } from './dialog/dialog.component';

@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    DialogComponent,
    DialogCurriculoComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    MaterialModule,
    NgxMaskModule.forRoot()
  ],
  exports: [
    HeaderComponent,
    FooterComponent
  ],
  providers: []
})
export class ComunsModule { }
