import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';

import { LoginService } from '../../../services/login.service';
import { AppService } from './../../../app.service';
import { Vaga } from './../../../models/Vagas.model';
import { CandidaturaService } from './../../../services/candidatura.service';
import { DialogConfirmacaoComponent } from './../dialog-confirmacao/dialog-confirmacao.component';

@Component({
  selector: 'app-dialog-vaga',
  templateUrl: './dialog-vaga.component.html',
  styleUrls: ['./dialog-vaga.component.css']
})
export class DialogVagaComponent implements OnInit {

  public dialogRef: MatDialogRef<DialogConfirmacaoComponent>;
  readMore = false;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
    private selfDialogRef: MatDialogRef<DialogVagaComponent>,
    public loginService: LoginService,
    public appService: AppService,
    public dialog: MatDialog,
    private candidaturaService: CandidaturaService,
    private router: Router) { }

  ngOnInit(): void {
  }

  candidatarClick(vaga: Vaga) {
    this.dialogRef = this.dialog.open(DialogConfirmacaoComponent, {
      disableClose: false
    });
    this.dialogRef.componentInstance.confirmMessage = `Realmente deseja se candidatar para a vaga ${vaga.nome}?`

    this.dialogRef.afterClosed().subscribe(result => {
      if(result) {
        if (this.loginService.objUsuarioAutenticado.tipoUsuario === 2) {
          this.candidaturaService.create(this.loginService.objUsuarioAutenticado.id, vaga.id).subscribe({
            next: (data) => {
              if (!this.appService.isNullOrUndefined(data)) {
                this.appService.mensagemSucesso("Candidatura realizada com sucesso!");
                this.router.navigate(['candidato/candidaturas']);
                this.selfDialogRef.close();
              }
            },
            error: (error) => {
              if (!this.appService.isNullOrUndefined(error.error.error) && error.error.error != '') {
                this.appService.mensagemErro(error.error.error);
              }
            },
            complete: () => {

            }
          })
        }
      }
    });
  }

}
