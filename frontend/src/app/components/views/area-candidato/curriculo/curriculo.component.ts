import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AppService } from './../../../../app.service';
import { Candidato } from './../../../../models/Candidato.model';
import { Curriculo } from './../../../../models/Curriculo.model';
import { CurriculoExperiencia } from './../../../../models/CurriculoExperiencia.model';
import { CurriculoFormacao } from './../../../../models/CurriculoFormacao.model';
import { CandidatoService } from './../../../../services/candidato.service';
import { CurriculoService } from './../../../../services/curriculo.service';
import { UsuarioService } from '../../../../services/usuario.service';
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
  public isEditavel: boolean = false;
  public isAlterandoFormacao: boolean = false;
  public isAlterandoExperiencia: boolean = false;

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
    public usuarioService: UsuarioService,
    private validaCepService: ValidaCepService,
    private candidatoService: CandidatoService,
    public appService: AppService,
    private router: Router) {
   }

  ngOnInit(): void {
    setTimeout(() => this.appService.scrollToTop(), 100);
    this.getDadosCurriculo();
  }

  getDadosCurriculo() {
    this.curriculoService.findByCandidato(this.usuarioService.objUsuarioAutenticado.id).subscribe({
      next: (data) => {
        if (!this.appService.isNullOrUndefined(data)) {
          this.curriculo = data;
          this.formacoes = data.formacoes;
          this.experiencias = data.experiencias;
        } else {
          this.candidatoService.findById(this.usuarioService.objUsuarioAutenticado.id).subscribe({
            next: (data) => {
              this.curriculo.nome = data.nome;
              this.curriculo.candidato = data;
            }
          })
        }
      },
      error: (msg) => {
        console.log(msg);
      },
      complete: () => {

      }
    })
  }

  abriuFormacoes() {
    if (!this.isAlterandoFormacao) {
      this.formacao = new CurriculoFormacao;
    }
  }

  salvarFormacao() {
    if (!this.isAlterandoFormacao) {
      this.formacoes.push(this.formacao);
      this.curriculo.formacoes = this.formacoes;
    }
    this.formacao = new CurriculoFormacao;
    this.expandirFormacoes = false;
    this.isAlterandoFormacao = false;
  }

  cancelarFormacao() {
    this.formacao = new CurriculoFormacao;
    this.expandirFormacoes = false;
  }

  excluirFormacaoClick(formacao: CurriculoFormacao) {
    let index: any = this.curriculo.formacoes?.indexOf(formacao);
    this.curriculo.formacoes?.splice(index, 1);
  }

  alterarFormacaoClick(formacao: CurriculoFormacao) {
    this.isAlterandoFormacao = true;
    this.formacao = formacao;
    this.expandirFormacoes = true;
  }

  abriuExperiencias() {
    if (!this.isAlterandoExperiencia) {
      this.experiencia = new CurriculoExperiencia;
    }
  }

  salvarExperiencia() {
    if (!this.isAlterandoExperiencia) {
      this.experiencias.push(this.experiencia);
      this.curriculo.experiencias = this.experiencias;
    }
    this.experiencia = new CurriculoExperiencia;
    this.expandirExperiencias = false;
  }

  cancelarExperiencia() {
    this.experiencia = new CurriculoExperiencia;
    this.expandirExperiencias = false;
  }

  excluirExperienciaClick(experiencia: CurriculoExperiencia) {
    let index: any = this.curriculo.experiencias?.indexOf(experiencia);
    this.curriculo.experiencias?.splice(index, 1);
  }

  alterarExperienciaClick(experiencia: CurriculoExperiencia) {
    this.isAlterandoExperiencia = true;
    this.experiencia = experiencia;
    this.expandirExperiencias = true;
  }

  salvarCurriculo() {
    this.curriculoService.save(this.curriculo).subscribe({
      next: (data) => {
        if (!this.appService.isNullOrUndefined(data)) {
          this.appService.mensagemSucesso("Currículo salvo com sucesso!");
          this.isEditavel = false;
          this.router.navigate(['candidato/area']);
        }
      },
      error: (error) => {

      },
      complete: () => {

      }
    })
  }

  validarCEP(cep: string) {
    if (cep.length === 8) {
      this.validaCepService.validarCep(cep).subscribe({
        next: (data) => {
          if (data.erro) {
            this.appService.mensagem("CEP inválido!");
          } else {
            this.curriculo.estado = data.uf;
            this.curriculo.cidade = data.localidade;
            this.curriculo.bairro = data.bairro;
            this.curriculo.rua = data.logradouro;
            this.curriculo.complemento = data.complemento;
          }
        },
        error: (err) => {

        },
        complete: () => {

        }
      })
    }
  }

  editarClick() {
    if (!this.isEditavel) {
      this.isEditavel = true;
    }
  }

}
