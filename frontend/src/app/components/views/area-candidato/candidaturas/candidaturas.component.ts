import { Candidatura } from './../../../../models/Candidatura.model';
import { LoginService } from './../../../../services/login.service';
import { CandidaturaService } from './../../../../services/candidatura.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-candidaturas',
  templateUrl: './candidaturas.component.html',
  styleUrls: ['./candidaturas.component.css']
})
export class CandidaturasComponent implements OnInit {

  public numeroCandidaturas: number;
  public candidaturas: Candidatura[] = [];

  constructor(public candidaturaService: CandidaturaService,
    public loginService: LoginService) {
      this.getNumeroCandidaturas();
      this.getCandidaturas();
    }

  ngOnInit(): void {

  }

  getCandidaturas() {
    let _this = this;
    this.candidaturaService.findAllByCandidato(this.loginService.objUsuarioAutenticado.id).subscribe({
      next(data) {
        _this.candidaturas = data;
      },
      error(msg) {
        console.log('Error', msg);
      },
      complete() {

      }
    })
  }

  getNumeroCandidaturas() {
    const _this = this;
    this.candidaturaService.getNumeroCandidaturas(this.loginService.objUsuarioAutenticado.id).subscribe({
      next(data) {
        _this.numeroCandidaturas = data;
      },
      error(msg) {
        console.log('Error', msg);
      },
      complete() {

      }
    });
  }

}
