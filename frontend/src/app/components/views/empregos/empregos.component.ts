import { Router } from '@angular/router';
import { AppService } from './../../../app.service';
import { LoginService } from './../../../services/login.service';
import { CandidaturaService } from './../../../services/candidatura.service';
import { DialogComponent } from './../../comuns/dialog/dialog.component';
import { Vaga } from '../../../models/vaga.model';
import { VagaService } from './../../../services/vaga.service';
import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PageEvent } from '@angular/material/paginator';

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
    private appService: AppService,
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
        const dialogRef = this.dialog.open(DialogComponent, {
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
    console.log('realizando candidatura...');
    if (this.loginService.objUsuarioAutenticado.tipoUsuario === 2) {
      this.candidaturaService.salvarCandidatura(this.loginService.objUsuarioAutenticado.id, idVaga).subscribe({
        next: (data) => {
          if (!this.appService.isNullOrUndefined(data)) {
            this.appService.mensagem("Candidatura realizada com sucesso!");
            this.router.navigate(['candidato/candidaturas']);
          }
        },
        error: (error) => {
          console.error(error);
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
