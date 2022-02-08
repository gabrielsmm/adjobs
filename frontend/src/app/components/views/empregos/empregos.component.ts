import { Vaga } from '../../../models/vaga.model';
import { VagaService } from './../../../services/vaga.service';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-empregos',
  templateUrl: './empregos.component.html',
  styleUrls: ['./empregos.component.css']
})
export class EmpregosComponent implements OnInit {

  @Input() estagios: boolean = false;
  @Input() labelInfoVagas: string = " de Emprego";

  public vagas: Vaga[] = [];

  constructor(private vagaService: VagaService) { }

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

  buscar() {
    console.log('Buscando...');
  }

}
