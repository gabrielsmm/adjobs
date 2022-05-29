import { Candidato } from './../../../../models/Candidato.model';
import { CandidatoService } from './../../../../services/candidato.service';
import { LoginService } from './../../../../services/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-minha-area',
  templateUrl: './minha-area.component.html',
  styleUrls: ['./minha-area.component.css']
})
export class MinhaAreaComponent implements OnInit {

  candidato: Candidato = {} as Candidato;

  constructor(public loginService: LoginService,
  public candidatoService: CandidatoService) {
    this.getCandidato();
  }

  ngOnInit(): void {

  }

  getCandidato() {
    let _this = this;
    this.candidatoService.findById(this.loginService.objUsuarioAutenticado.id).subscribe({
      next(data) {
        _this.candidato = data;
      },
      error(err) {
        console.log(err);
      },
      complete() {

      }
    });
  }

}
