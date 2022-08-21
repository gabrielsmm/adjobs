import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';

import { AppService } from '../../../app.service';
import { UsuarioService } from './../../../services/usuario.service';

@Component({
  selector: 'app-dialog-altera-senha',
  templateUrl: './dialog-altera-senha.component.html',
  styleUrls: ['./dialog-altera-senha.component.css']
})
export class DialogAlteraSenhaComponent implements OnInit {

  showPassword: boolean = false;
  erroPassword: boolean = false;
  password: string;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
    public selfDialogRef: MatDialogRef<DialogAlteraSenhaComponent>,
    public appService: AppService,
    public dialog: MatDialog,
    public usuarioService: UsuarioService) { }

  ngOnInit(): void {
  }

  confirmarClick() {
    if (this.appService.isNullOrUndefined(this.password) || this.password == '') {
      this.erroPassword = true;
      return;
    } else {
      this.erroPassword = false;
    }
    this.usuarioService.alterarSenha(this.data, this.password).subscribe({
      next: (data) => {
        this.appService.mensagemSucesso("Senha alterada com sucesso!");
        setTimeout(() => {
          this.selfDialogRef.close()
        }, 2000);
      },
      error: (err) => {
        if (!this.appService.isNullOrUndefined(err.error.error)) {
          this.appService.mensagemErro(err.error.error);
        }
      },
      complete: () => {

      }
    })
  }

  toggleShowPassword() {
    this.showPassword = !this.showPassword;
  }

}
