import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

import { AppService } from './../../../../app.service';
import { Empresa } from './../../../../models/Empresa.model';
import { EmpresaService } from './../../../../services/empresa.service';
import { UsuarioService } from './../../../../services/usuario.service';
import { VagaService } from './../../../../services/vaga.service';
import { DialogAlteraSenhaComponent } from './../../../comuns/dialog-altera-senha/dialog-altera-senha.component';

@Component({
  selector: 'app-minha-area-empresa',
  templateUrl: './minha-area.component.html',
  styleUrls: ['./minha-area.component.css']
})
export class MinhaAreaEmpresaComponent implements OnInit {

  public dialogAlteraSenhaRef: MatDialogRef<DialogAlteraSenhaComponent>;

  empresa: Empresa = new Empresa;
  public qtdPostadas: number = 0;
  public qtdCandidatos: number = 0;
  public porcentagem: number = 0;

  constructor(private empresaService: EmpresaService,
  public usuarioService: UsuarioService,
  private vagaService: VagaService,
  public appService: AppService,
  public dialog: MatDialog) {

  }

  ngOnInit(): void {
    setTimeout(() => this.appService.scrollToTop(), 100);
    this.getEmpresa();
  }

  getEmpresa() {
    this.empresaService.findById(this.usuarioService.objUsuarioAutenticado.id).subscribe({
      next: (data) => {
        this.empresa = data;
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
    this.vagaService.getContador(this.empresa.id).subscribe({
      next: (data) => {
        this.qtdPostadas = data.qtdPostadas;
        this.qtdCandidatos = data.qtdCandidatos;
        this.porcentagem = data.porcentagem;
        if (this.porcentagem >= 100) {
          this.usuarioService.objUsuarioAutenticado.podeDivulgar = true;
        } else {
          this.usuarioService.objUsuarioAutenticado.podeDivulgar = false;
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
      data: this.empresa.id,
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
