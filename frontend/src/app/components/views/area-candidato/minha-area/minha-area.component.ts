import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

import { AppService } from './../../../../app.service';
import { Candidato } from './../../../../models/Candidato.model';
import { CandidatoService } from './../../../../services/candidato.service';
import { CandidaturaService } from './../../../../services/candidatura.service';
import { UsuarioService } from './../../../../services/usuario.service';
import { DialogAlteraSenhaComponent } from './../../../comuns/dialog-altera-senha/dialog-altera-senha.component';

@Component({
  selector: 'app-minha-area-candidato',
  templateUrl: './minha-area.component.html',
  styleUrls: ['./minha-area.component.css']
})
export class MinhaAreaCandidatoComponent implements OnInit {

  public dialogAlteraSenhaRef: MatDialogRef<DialogAlteraSenhaComponent>;

  candidato: Candidato = new Candidato;
  public qtdEnviados: number = 0;
  public qtdEmProcesso: number = 0;
  public qtdFinalista: number = 0;
  public porcentagem: number = 0;

  constructor(public usuarioService: UsuarioService,
  public candidatoService: CandidatoService,
  public candidaturaService: CandidaturaService,
  public appService: AppService,
  public dialog: MatDialog) {

  }

  ngOnInit(): void {
    setTimeout(() => this.appService.scrollToTop(), 100);
    this.getCandidato();
  }

  getCandidato() {
    this.candidatoService.findById(this.usuarioService.objUsuarioAutenticado.id).subscribe({
      next: (data) => {
        this.candidato = data;
        this.getContador();
      },
      error: (err) => {
        console.log(err);
      },
      complete: () => {

      }
    });
  }

  getContador() {
    this.candidaturaService.getContador(this.candidato.id).subscribe({
      next: (data) => {
        this.qtdEnviados = data.qtdEnviados;
        this.qtdEmProcesso = data.qtdEmProcesso;
        this.qtdFinalista = data.qtdFinalista;
        this.porcentagem = data.porcentagem;
        if (this.porcentagem >= 100) {
          this.usuarioService.objUsuarioAutenticado.podeCandidatar = true;
        } else {
          this.usuarioService.objUsuarioAutenticado.podeCandidatar = false;
        }
      },
      error: (err) => {
        console.log(err);
      },
      complete: () => {

      }
    })
  }

  alterarSenhaClick() {
    this.dialogAlteraSenhaRef = this.dialog.open(DialogAlteraSenhaComponent, {
      disableClose: false,
      data: this.candidato.id,
      height: '280px',
      width: '500px'
    });

    this.dialogAlteraSenhaRef.afterClosed().subscribe(result => {
      if(result) {
        //Ação
      }
    });
  }

}
