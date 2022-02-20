import { DialogComponent } from './../../comuns/dialog/dialog.component';
import { Vaga } from '../../../models/vaga.model';
import { VagaService } from './../../../services/vaga.service';
import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

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
    this.vagaService.getListaPaginada().subscribe({
      next(data) {
        _this.vagas = data['content'];
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
    console.log('Buscando...');
  }

}
