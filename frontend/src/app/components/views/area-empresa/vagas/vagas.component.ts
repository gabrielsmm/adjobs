import { LoginService } from './../../../../services/login.service';
import { VagaService } from './../../../../services/vaga.service';
import { Vaga } from './../../../../models/vaga.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vagas',
  templateUrl: './vagas.component.html',
  styleUrls: ['./vagas.component.css']
})
export class VagasComponent implements OnInit {

  public numeroVagas: number;
  public vagas: Vaga[] = [];

  constructor(private vagaService: VagaService,
  private loginService: LoginService) {
    this.getNumeroVagas();
    this.getVagas();
  }

  ngOnInit(): void {
  }

  getVagas() {
    let _this = this;
    this.vagaService.findAllByEmpresa(this.loginService.objUsuarioAutenticado.id).subscribe({
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

  getNumeroVagas() {
    const _this = this;
    this.vagaService.getNumeroVagasPorEmpresa(this.loginService.objUsuarioAutenticado.id).subscribe({
      next(data) {
        _this.numeroVagas = data;
      },
      error(msg) {
        console.log('Error', msg);
      },
      complete() {

      }
    });
  }

}
