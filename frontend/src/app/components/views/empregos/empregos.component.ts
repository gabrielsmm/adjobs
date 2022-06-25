import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';

import { Vaga } from '../../../models/vaga.model';
import { AppService } from './../../../app.service';
import { CandidaturaService } from './../../../services/candidatura.service';
import { LoginService } from './../../../services/login.service';
import { VagaService } from './../../../services/vaga.service';
import { DialogVagaComponent } from './../../comuns/dialog-vaga/dialog-vaga.component';

@Component({
  selector: 'app-empregos',
  templateUrl: './empregos.component.html',
  styleUrls: ['./empregos.component.css']
})
export class EmpregosComponent implements OnInit {

  @Input() estagios: boolean = false;
  @Input() labelInfoVagas: string = " de Emprego";

  public vagas: Vaga[] = [];
  public vaga: Vaga;
  public pesquisa: string = "";
  public page = 0;
  public size = 5;
  public first: boolean;
  public last: boolean;

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
    this.vagaService.getListaPaginada(this.page, this.size, this.pesquisa).subscribe({
      next: (data) => {
        this.vagas = data['content'];
        this.first = data['first'];
        this.last = data['last'];
      },
      error: (msg) => {
        console.log('Error', msg);
      },
      complete: () => {

      }
    });
  }

  getSomenteEstagios() {
    const _this = this;
    this.vagaService.getSomenteEstagios().subscribe({
      next(data) {
        _this.vagas = data;
      },
      error(msg) {
        console.log('Error', msg);
      },
      complete() {

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

  candidatarClick(idVaga: any) {
    if (this.loginService.objUsuarioAutenticado.tipoUsuario === 2) {
      this.candidaturaService.create(this.loginService.objUsuarioAutenticado.id, idVaga).subscribe({
        next: (data) => {
          if (!this.appService.isNullOrUndefined(data)) {
            this.appService.mensagem("Candidatura realizada com sucesso!");
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

  buscar() {
    this.getListaPaginada();
  }

  irPaginaAnterior() {
    this.page = --this.page;
    this.buscar();
  }

  irPaginaPosterior() {
    this.page = ++this.page;
    this.buscar();
  }

}
