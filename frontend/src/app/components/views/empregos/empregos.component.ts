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
    public dialog: MatDialog) { }

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
    const _this = this;
    this.vagaService.getListaPaginada(this.page, this.size, this.pesquisa).subscribe({
      next(data) {
        _this.vagas = data['content'];
        _this.first = data['first'];
        _this.last = data['last'];
      },
      error(msg) {
        console.log('Error', msg);
      },
      complete() {

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
    const _this = this;
    this.vagaService.getDados(idVaga).subscribe({
      next(data: Vaga) {
        _this.vaga = data;
        console.log(_this.vaga);
        const dialogRef = _this.dialog.open(DialogComponent, {
          data: _this.vaga,
          height: '500px',
          width: '700px'
        });

        dialogRef.afterClosed().subscribe(result => {
          console.log(`Dialog fechado`);
        })
      },
      error(msg) {
        console.log('Error', msg);
      },
      complete() {

      }
    })
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
