import { Candidato } from './../../../../models/Candidato.model';
import { CandidatoService } from './../../../../services/candidato.service';
import { Component, OnInit } from '@angular/core';

import { AppService } from './../../../../app.service';
import { Curriculo } from './../../../../models/Curriculo.model';
import { CurriculoExperiencia } from './../../../../models/CurriculoExperiencia.model';
import { CurriculoFormacao } from './../../../../models/CurriculoFormacao.model';
import { CurriculoService } from './../../../../services/curriculo.service';
import { LoginService } from './../../../../services/login.service';
import { ValidaCepService } from './../../../../services/validaCep.service';

@Component({
  selector: 'app-curriculo',
  templateUrl: './curriculo.component.html',
  styleUrls: ['./curriculo.component.css']
})
export class CurriculoComponent implements OnInit {

  public candidato: Candidato;
  public curriculo: Curriculo = new Curriculo;
  public formacao: CurriculoFormacao = new CurriculoFormacao;
  public experiencia: CurriculoExperiencia = new CurriculoExperiencia;
  public formacoes: CurriculoFormacao[] = [];
  public experiencias: CurriculoExperiencia[] = [];
  public expandirFormacoes: boolean = false;
  public expandirExperiencias: boolean = false;

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

  nivelFormacao = [
    {value: 0, viewValue: 'Ensino Fundamental'},
    {value: 1, viewValue: 'Curso extra-curricular'},
    {value: 2, viewValue: 'Ensino médio'},
    {value: 3, viewValue: 'Ensino superior'},
    {value: 4, viewValue: 'Pós-graduação - Especialização/MBA'},
    {value: 5, viewValue: 'Pós-graduação - Mestrado'},
    {value: 6, viewValue: 'Pós-graduação - Doutorado'},
  ];

  statusFormacao = [
    {value: 0, viewValue: 'Concluído'},
    {value: 1, viewValue: 'Cursando'},
    {value: 2, viewValue: 'Trancado'},
  ];

  constructor(public curriculoService: CurriculoService,
    public loginService: LoginService,
    private validaCepService: ValidaCepService,
    private candidatoService: CandidatoService,
    public appService: AppService) {
    this.getDadosCurriculo();
   }

  ngOnInit(): void {

  }

  getDadosCurriculo() {
    let _this = this;
    this.curriculoService.findByCandidato(this.loginService.objUsuarioAutenticado.id).subscribe({
      next(data) {
        if (!_this.appService.isNullOrUndefined(data)) {
          _this.curriculo = data;
          _this.formacoes = data.formacoes;
          _this.experiencias = data.experiencias;
        } else {
          _this.candidatoService.findById(_this.loginService.objUsuarioAutenticado.id).subscribe({
            next(data) {
              _this.curriculo.nome = data.nome;
              _this.curriculo.candidato = data;
            }
          })
        }
      },
      error(msg) {
        console.log(msg);
      },
      complete() {

      }
    })
  }

  abriuFormacoes() {
    this.formacao = new CurriculoFormacao;
  }

  salvarFormacao() {
    this.formacoes.push(this.formacao);
    this.curriculo.formacoes = this.formacoes;
    this.formacao = new CurriculoFormacao;
    this.expandirFormacoes = false;
    console.log(this.formacoes);
  }

  cancelarFormacao() {
    this.formacao = new CurriculoFormacao;
    this.expandirFormacoes = false;
  }

  abriuExperiencias() {
    this.experiencia = new CurriculoExperiencia;
  }

  salvarExperiencia() {
    this.experiencias.push(this.experiencia);
    this.curriculo.experiencias = this.experiencias;
    this.experiencia = new CurriculoExperiencia;
    this.expandirExperiencias = false;
    console.log(this.experiencias);
  }

  cancelarExperiencia() {
    this.experiencia = new CurriculoExperiencia;
    this.expandirExperiencias = false;
  }

  salvarCurriculo() {
    let _this = this;
    this.curriculoService.save(this.curriculo).subscribe({
      next(data) {
        if (!_this.appService.isNullOrUndefined(data)) {
          _this.appService.mensagem("Currículo salvo");
        }
      },
      error(error) {

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
