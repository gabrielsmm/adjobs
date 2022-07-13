import { VagaService } from './../../../../services/vaga.service';
import { LoginService } from './../../../../services/login.service';
import { EmpresaService } from './../../../../services/empresa.service';
import { Empresa } from './../../../../models/Empresa.model';
import { Component, OnInit } from '@angular/core';

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
  private vagaService: VagaService) {
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
