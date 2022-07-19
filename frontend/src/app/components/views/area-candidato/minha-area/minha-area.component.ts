import { Component, OnInit } from '@angular/core';

import { AppService } from './../../../../app.service';
import { Candidato } from './../../../../models/Candidato.model';
import { CandidatoService } from './../../../../services/candidato.service';
import { CandidaturaService } from './../../../../services/candidatura.service';
import { LoginService } from './../../../../services/login.service';

@Component({
  selector: 'app-minha-area-candidato',
  templateUrl: './minha-area.component.html',
  styleUrls: ['./minha-area.component.css']
})
export class MinhaAreaCandidatoComponent implements OnInit {

  candidato: Candidato = new Candidato;
  public qtdEnviados: number = 0;
  public qtdEmProcesso: number = 0;
  public qtdFinalista: number = 0;

  constructor(public loginService: LoginService,
  public candidatoService: CandidatoService,
  public candidaturaService: CandidaturaService,
  public appService: AppService) {
    this.getCandidato();
  }

  ngOnInit(): void {

  }

  getCandidato() {
    this.candidatoService.findById(this.loginService.objUsuarioAutenticado.id).subscribe({
      next: (data) => {
        this.candidato = data;
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
    this.candidaturaService.getContador(this.candidato.id).subscribe({
      next: (data) => {
        this.qtdEnviados = data.qtdEnviados;
        this.qtdEmProcesso = data.qtdEmProcesso;
        this.qtdFinalista = data.qtdFinalista;
      },
      error: (err) => {
        console.log(err);
      },
      complete: () => {

      }
    })
  }

}
