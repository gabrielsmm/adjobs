import { Component, Input, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';

import { Vaga } from '../../../models/vaga.model';
import { AppService } from './../../../app.service';
import { CandidaturaService } from './../../../services/candidatura.service';
import { LoginService } from './../../../services/login.service';
import { VagaService } from './../../../services/vaga.service';
import { DialogConfirmacaoComponent } from './../../comuns/dialog-confirmacao/dialog-confirmacao.component';
import { DialogVagaComponent } from './../../comuns/dialog-vaga/dialog-vaga.component';

@Component({
  selector: 'app-empregos',
  templateUrl: './empregos.component.html',
  styleUrls: ['./empregos.component.css']
})
export class EmpregosComponent implements OnInit {

  @Input() estagios: boolean = false;
  @Input() labelInfoVagas: string = " de Emprego";

  public dialogRef: MatDialogRef<DialogConfirmacaoComponent>;
  public vagas: Vaga[] = [];
  public vaga: Vaga;
  public pesquisa: string = "";
  public tipo: number;
  public page = 0;
  public size = 5;
  public first: boolean;
  public last: boolean;
  public totalElements = 0;

  constructor(private vagaService: VagaService,
    private candidaturaService: CandidaturaService,
    public loginService: LoginService,
    public appService: AppService,
    public dialog: MatDialog,
    private router: Router) { }

  ngOnInit(): void {
    this.getVagas();
  }

  getVagas() {
    if (this.estagios) {
      this.getSomenteEstagios();
    } else {
      this.getListaPaginada();
    }
  }

  getListaPaginada() {
    this.vagaService.getListaPaginada(this.page, this.size, this.pesquisa, this.tipo).subscribe({
      next: (data) => {
        this.vagas = data['content'];
        this.first = data['first'];
        this.last = data['last'];
        this.totalElements = data['totalElements'];
      },
      error: (msg) => {
        console.log('Error', msg);
      },
      complete: () => {

      }
    });
  }

  getSomenteEstagios() {
    this.vagaService.getSomenteEstagios().subscribe({
      next: (data) => {
        this.vagas = data;
      },
      error: (msg) => {
        console.log('Error', msg);
      },
      complete: () => {

      }
    })
  }

  openDetalhes(idVaga: any) {
    this.vagaService.getDados(idVaga).subscribe({
      next: (data: Vaga) => {
        this.vaga = data;
        const dialogRef = this.dialog.open(DialogVagaComponent, {
          data: this.vaga,
          height: '600px',
          width: '700px'
        });

        dialogRef.afterClosed().subscribe(result => {
          console.log(`Dialog fechado`);
        })
      },
      error: (msg) => {
        console.error('Error', msg);
      },
      complete: () => {

      }
    })
  }

  candidatarClick(vaga: Vaga) {
    this.dialogRef = this.dialog.open(DialogConfirmacaoComponent, {
      disableClose: false
    });
    this.dialogRef.componentInstance.confirmMessage = `Realmente deseja se candidatar para a vaga ${vaga.id} - ${vaga.nome}?`

    this.dialogRef.afterClosed().subscribe(result => {
      if(result) {
        if (this.loginService.objUsuarioAutenticado.tipoUsuario === 2) {
          this.candidaturaService.create(this.loginService.objUsuarioAutenticado.id, vaga.id).subscribe({
            next: (data) => {
              if (!this.appService.isNullOrUndefined(data)) {
                this.appService.mensagemSucesso("Candidatura realizada com sucesso!");
                this.router.navigate(['candidato/candidaturas']);
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

  buscar() {
    this.getListaPaginada();
  }

  buscarTipo(tipo: number = -1) {
    this.tipo = tipo;
    this.buscar();
  }

  irPaginaAnterior() {
    this.page = --this.page;
    this.buscar();
    this.scrollToTop();
  }

  irPaginaPosterior() {
    this.page = ++this.page;
    this.buscar();
    this.scrollToTop();
  }

  scrollToTop() {
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth'
    });
  }

}
