import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTabGroup } from '@angular/material/tabs';

import { AppService } from '../../../app.service';
import { Empresa } from '../../../models/Empresa.model';
import { EmpresaService } from '../../../services/empresa.service';
import { Candidato } from './../../../models/Candidato.model';
import { CandidatoService } from './../../../services/candidato.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  @ViewChild('tabs') tabGroup: MatTabGroup;

  public empresa: Empresa = new Empresa();
  public candidato: Candidato = new Candidato();

  constructor(private empresaService: EmpresaService,
    private candidatoService: CandidatoService,
    private appService: AppService) { }

  ngOnInit(): void {
  }

  registrarEmpresa() {
    if (!this.validarRegistroEmpresa(this.empresa)) {
      return;
    }
    let _this = this;
    this.empresaService.create(this.empresa).subscribe({
      next(data) {
        _this.appService.mensagem("Registro realizado com sucesso!");
        console.log(data);
      },
      error(err) {
        console.log(err);
        if (!_this.appService.isNullOrUndefined(err.error.error)) {
          _this.appService.mensagem(err.error.error);
        } else {
          for(let i = 0; i < err.error.errors.length; i++){
            _this.appService.mensagem(err.error.errors[i].message);
          }
        }
      },
      complete() {

      }
    });
  }

  registrarCandidato() {
    if (!this.validarRegistroCandidato(this.candidato)) {
      return;
    }
    let _this = this;
    this.candidatoService.create(this.candidato).subscribe({
      next(data) {
        _this.appService.mensagem("Registro realizado com sucesso!");
        console.log(data);
      },
      error(err) {
        console.log(err);
        if (!_this.appService.isNullOrUndefined(err.error.error)) {
          _this.appService.mensagem(err.error.error);
        } else {
          for(let i = 0; i < err.error.errors.length; i++){
            _this.appService.mensagem(err.error.errors[i].message);
          }
        }
      },
      complete() {

      }
    });
  }

  private validarRegistroEmpresa(empresa: Empresa): boolean {

    if (this.appService.isNullOrUndefined(empresa.nome)) {
      this.appService.mensagem("Preencha o nome da empresa");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.cnpj)) {
      this.appService.mensagem("Preencha o CNPJ da empresa");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.qtdFuncionarios)) {
      this.appService.mensagem("Preencha a quantidade de funcionários que a empresa possui");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.cep)) {
      this.appService.mensagem("Preencha o CEP da empresa");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.nomeResponsavel)) {
      this.appService.mensagem("Preencha o nome do responsável da empresa");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.telefone)) {
      this.appService.mensagem("Preencha o telefone de contato da empresa");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.celular)) {
      this.appService.mensagem("Preencha o celular de contato da empresa");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.email)) {
      this.appService.mensagem("Preencha o email");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.senha)) {
      this.appService.mensagem("Preencha o campo senha");
      return false;
    }

    return true;
  }

  private validarRegistroCandidato(candidato: Candidato): boolean {

    if (this.appService.isNullOrUndefined(candidato.nome)) {
      this.appService.mensagem("Preencha o nome");
      return false;
    }

    if (this.appService.isNullOrUndefined(candidato.cep)) {
      this.appService.mensagem("Preencha o CEP");
      return false;
    }

    if (this.appService.isNullOrUndefined(candidato.cargo)) {
      this.appService.mensagem("Selecione um cargo");
      return false;
    }

    if (this.appService.isNullOrUndefined(candidato.email)) {
      this.appService.mensagem("Preencha o email");
      return false;
    }

    if (this.appService.isNullOrUndefined(candidato.senha)) {
      this.appService.mensagem("Preencha o campo senha");
      return false;
    }

    return true;
  }

  irParaTabRegistrar() {
    this.tabGroup.selectedIndex = 1;
  }
}
