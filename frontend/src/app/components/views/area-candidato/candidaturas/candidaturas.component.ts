import { AppService } from './../../../../app.service';
import { DialogConfirmacaoComponent } from './../../../comuns/dialog-confirmacao/dialog-confirmacao.component';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Candidatura } from './../../../../models/Candidatura.model';
import { LoginService } from './../../../../services/login.service';
import { CandidaturaService } from './../../../../services/candidatura.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-candidaturas',
  templateUrl: './candidaturas.component.html',
  styleUrls: ['./candidaturas.component.css']
})
export class CandidaturasComponent implements OnInit {

  public dialogRef: MatDialogRef<DialogConfirmacaoComponent>;
  public numeroCandidaturas: number;
  public candidaturas: Candidatura[] = [];

  constructor(public candidaturaService: CandidaturaService,
    public loginService: LoginService,
    private appService: AppService,
    public dialog: MatDialog) {
      this.getNumeroCandidaturas();
      this.getCandidaturas();
    }

  ngOnInit(): void {

  }

  getCandidaturas() {
    let _this = this;
    this.candidaturaService.findAllByCandidato(this.loginService.objUsuarioAutenticado.id).subscribe({
      next(data) {
        _this.candidaturas = data;
      },
      error(msg) {
        console.log('Error', msg);
      },
      complete() {

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
