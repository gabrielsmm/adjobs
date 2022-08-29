import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

import { UsuarioService } from '../../../services/usuario.service';
import { AppService } from './../../../app.service';
import { Curriculo } from './../../../models/Curriculo.model';

@Component({
  selector: 'app-dialog-curriculo',
  templateUrl: './dialog-curriculo.component.html',
  styleUrls: ['./dialog-curriculo.component.css']
})
export class DialogCurriculoComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: Curriculo,
    public usuarioService: UsuarioService,
    private appService: AppService) { }

  ngOnInit(): void {
  }

  printSituacao(situacao: any) {
    let strSituacao = '';
    for (const obj of this.appService.formacaoStatus) {
      if (obj.value == situacao) {
        strSituacao = obj.viewValue;
      }
    }
    return strSituacao;
  }

  printNivel(nivel: any) {
    let strNivel = '';
    for (const obj of this.appService.formacaoNivel) {
      if (obj.value == nivel) {
        strNivel = obj.viewValue;
      }
    }
    return strNivel;
  }

}
