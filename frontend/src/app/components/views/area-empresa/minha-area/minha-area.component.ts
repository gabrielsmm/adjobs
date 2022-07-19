import { Component, OnInit } from '@angular/core';

import { AppService } from './../../../../app.service';
import { Empresa } from './../../../../models/Empresa.model';
import { EmpresaService } from './../../../../services/empresa.service';
import { LoginService } from './../../../../services/login.service';
import { VagaService } from './../../../../services/vaga.service';

@Component({
  selector: 'app-minha-area-empresa',
  templateUrl: './minha-area.component.html',
  styleUrls: ['./minha-area.component.css']
})
export class MinhaAreaEmpresaComponent implements OnInit {

  empresa: Empresa = new Empresa;
  public qtdPostadas: number = 0;
  public qtdCandidatos: number = 0;

  constructor(private empresaService: EmpresaService,
  private loginService: LoginService,
  private vagaService: VagaService,
  public appService: AppService) {
    this.getEmpresa();
  }

  ngOnInit(): void {
  }

  getEmpresa() {
    this.empresaService.findById(this.loginService.objUsuarioAutenticado.id).subscribe({
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
      },
      error: (err) => {
        console.log(err);
      },
      complete: () => {

      }
    })
  }

}
