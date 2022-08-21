import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { NgxMaskModule } from 'ngx-mask';

import { MaterialModule } from './../../material.module';
import { DialogAlteraSenhaComponent } from './dialog-altera-senha/dialog-altera-senha.component';
import { DialogConfirmacaoComponent } from './dialog-confirmacao/dialog-confirmacao.component';
import { DialogCurriculoComponent } from './dialog-curriculo/dialog-curriculo.component';
import { DialogVagaComponent } from './dialog-vaga/dialog-vaga.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    DialogVagaComponent,
    DialogCurriculoComponent,
    DialogAlteraSenhaComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    MaterialModule,
    FormsModule,
    NgxMaskModule.forRoot()
  ],
  exports: [
    HeaderComponent,
    FooterComponent
  ],
  providers: [],
  entryComponents: [
    DialogConfirmacaoComponent
  ]
})
export class ComunsModule { }
