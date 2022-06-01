import { Component, OnInit } from '@angular/core';

import { AppService } from './../../../../app.service';
import { Curriculo } from './../../../../models/Curriculo.model';
import { CurriculoService } from './../../../../services/curriculo.service';
import { LoginService } from './../../../../services/login.service';
import { ValidaCepService } from './../../../../services/validaCep.service';

@Component({
  selector: 'app-curriculo',
  templateUrl: './curriculo.component.html',
  styleUrls: ['./curriculo.component.css']
})
export class CurriculoComponent implements OnInit {

  public curriculo: Curriculo = {} as Curriculo;

  estadosCivis = [
    {value: 0, viewValue: 'Casado(a)'},
    {value: 1, viewValue: 'Divorciado(a)'},
    {value: 2, viewValue: 'Separado(a)'},
    {value: 3, viewValue: 'Solteiro(a)'},
    {value: 4, viewValue: 'Viúvio(a)'},
  ];

  sexos = [
    {value: 0, viewValue: 'Masculino'},
    {value: 1, viewValue: 'Feminino'},
  ];

  constructor(public curriculoService: CurriculoService,
    public loginService: LoginService,
    private validaCepService: ValidaCepService,
    public appService: AppService) {
    this.getDadosCurriculo();
   }

  ngOnInit(): void {

  }

  getDadosCurriculo() {
    let _this = this;
    this.curriculoService.findByCandidato(this.loginService.objUsuarioAutenticado.id).subscribe({
      next(data) {
        _this.curriculo = data;
        console.log(_this.curriculo);
      },
      error(msg) {
        console.log(msg);
      },
      complete() {

      }
    })
  }

  validarCEP(cep: string) {
    if (cep.length === 8) {
      let _this = this;
      this.validaCepService.validarCep(cep).subscribe({
        next(data) {
          console.log(data);
          if (data.erro) {
            _this.appService.mensagem("CEP inválido!");
          } else {
            _this.curriculo.estado = data.uf;
            _this.curriculo.cidade = data.localidade;
            _this.curriculo.bairro = data.bairro;
            _this.curriculo.rua = data.logradouro;
            _this.curriculo.complemento = data.complemento;
          }
        },
        error(err) {

        },
        complete() {

        }
      })
    }
  }

}
