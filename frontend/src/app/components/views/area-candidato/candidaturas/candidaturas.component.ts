import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

import { AppService } from './../../../../app.service';
import { Candidatura } from './../../../../models/Candidatura.model';
import { CandidaturaService } from './../../../../services/candidatura.service';
import { LoaderService } from './../../../../services/loader.service';
import { LoginService } from './../../../../services/login.service';
import { DialogConfirmacaoComponent } from './../../../comuns/dialog-confirmacao/dialog-confirmacao.component';

@Component({
  selector: 'app-candidaturas',
  templateUrl: './candidaturas.component.html',
  styleUrls: ['./candidaturas.component.css']
})
export class CandidaturasComponent implements OnInit {

  public dialogRef: MatDialogRef<DialogConfirmacaoComponent>;
  public numeroCandidaturas: number;
  public candidaturas: Candidatura[] = [];
  public readMore = false;

  constructor(public candidaturaService: CandidaturaService,
    public loginService: LoginService,
    public appService: AppService,
    public dialog: MatDialog,
    public loaderService: LoaderService) {
      this.getNumeroCandidaturas();
      this.getCandidaturas();
    }

  ngOnInit(): void {

  }

  getCandidaturas() {
    this.candidaturaService.findAllByCandidato(this.loginService.objUsuarioAutenticado.id).subscribe({
      next: (data) => {
        this.candidaturas = data;
      },
      error: (msg) => {
        console.log('Error', msg);
      },
      complete: () => {

      }
    })
  }

  getNumeroCandidaturas() {
    const _this = this;
    this.candidaturaService.getNumeroCandidaturas(this.loginService.objUsuarioAutenticado.id).subscribe({
      next(data) {
        _this.numeroCandidaturas = data;
      },
      error(msg) {
        console.log('Error', msg);
      },
      complete() {

      }
    });
  }

  excluirCandidaturaClick(candidatura: Candidatura) {
    this.dialogRef = this.dialog.open(DialogConfirmacaoComponent, {
      disableClose: false
    });
    this.dialogRef.componentInstance.confirmMessage = `Realmente deseja excluir a candidatura para a vaga ${candidatura.vaga.id} - ${candidatura.vaga.nome}?`

    this.dialogRef.afterClosed().subscribe(result => {
      if(result) {
        candidatura.status = 4; //CANCELADA
        this.candidaturaService.update(candidatura).subscribe({
          next: (data) => {
            if (!this.appService.isNullOrUndefined(data)) {
              this.getNumeroCandidaturas();
              this.getCandidaturas();
            }
          },
          error: (error) => {
            console.error(error);
          },
          complete: () => {

          }
        });
      }
    });
  }

}
