import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatTabGroup } from '@angular/material/tabs';
import { Router } from '@angular/router';

import { AppService } from '../../../app.service';
import { Empresa } from '../../../models/Empresa.model';
import { EmpresaService } from '../../../services/empresa.service';
import { Candidato } from './../../../models/Candidato.model';
import { CandidatoService } from './../../../services/candidato.service';
import { ValidaCepService } from './../../../services/validaCep.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  @ViewChild('tabs') tabGroup: MatTabGroup;

  public empresa: Empresa = new Empresa();
  public candidato: Candidato = new Candidato();
  public isCandidato: boolean = true;
  public isEmpresa: boolean = false;
  // public cep = new FormControl([
  //   Validators.required,
  //   Validators.maxLength(8)
  // ]);

  constructor(private empresaService: EmpresaService,
    private candidatoService: CandidatoService,
    private appService: AppService,
    private router: Router,
    private validaCepService: ValidaCepService) { }

  ngOnInit(): void {
  }

  candidatoClick() {
    this.isCandidato = true;
    this.isEmpresa = false;
  }

  empresaClick() {
    this.isEmpresa = true;
    this.isCandidato = false;
  }

  irParaLogin() {
    this.router.navigate(['/login']);
  }

  registrarEmpresa() {
    if (!this.validarRegistroEmpresa(this.empresa)) {
      return;
    }
    this.empresaService.create(this.empresa).subscribe({
      next: (data) => {
        this.appService.mensagemSucesso("Registro realizado com sucesso!");
        setTimeout(() => {this.irParaLogin();}, 1500);
        // let usuario: Usuario = new Usuario();
        // usuario = Object.assign(usuario, data);
        // _this.loginService.usuarioAutenticado = true;
        // _this.loginService.objUsuarioAutenticado = usuario;
      },
      error: (err) => {
        console.log(err);
        if (!this.appService.isNullOrUndefined(err.error.error)) {
          this.appService.mensagem(err.error.error);
        } else {
          for(let i = 0; i < err.error.errors.length; i++){
            this.appService.mensagem(err.error.errors[i].message);
          }
        }
      },
      complete: () => {

      }
    });
  }

  registrarCandidato() {
    if (!this.validarRegistroCandidato(this.candidato)) {
      return;
    }
    this.candidatoService.create(this.candidato).subscribe({
      next: (data) => {
        this.appService.mensagemSucesso("Registro realizado com sucesso!");
        setTimeout(() => {this.irParaLogin();}, 1500);
        // let usuario: Usuario = new Usuario();
        // usuario = Object.assign(usuario, data);
        // _this.loginService.usuarioAutenticado = true;
        // _this.loginService.objUsuarioAutenticado = usuario;
        // _this.router.navigate(['empregos']);
      },
      error: (err) => {
        console.log(err);
        if (!this.appService.isNullOrUndefined(err.error.error)) {
          this.appService.mensagem(err.error.error);
        } else {
          for(let i = 0; i < err.error.errors.length; i++){
            this.appService.mensagem(err.error.errors[i].message);
          }
        }
      },
      complete: () => {

      }
    });
  }

  private validarRegistroEmpresa(empresa: Empresa): boolean {

    if (this.appService.isNullOrUndefined(empresa.nome)) {
      this.appService.mensagemErro("Preencha o nome da empresa");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.cnpj)) {
      this.appService.mensagemErro("Preencha o CNPJ da empresa");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.qtdFuncionarios)) {
      this.appService.mensagemErro("Preencha a quantidade de funcionários que a empresa possui");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.cep)) {
      this.appService.mensagemErro("Preencha o CEP da empresa");
      return false;
    }

    if (!this.validarCEP(empresa.cep)) {
      this.appService.mensagemErro("CEP inválido");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.nomeResponsavel)) {
      this.appService.mensagemErro("Preencha o nome do responsável da empresa");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.telefone)) {
      this.appService.mensagemErro("Preencha o telefone de contato da empresa");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.celular)) {
      this.appService.mensagemErro("Preencha o celular de contato da empresa");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.email)) {
      this.appService.mensagemErro("Preencha o email");
      return false;
    }

    if (this.appService.isNullOrUndefined(empresa.senha)) {
      this.appService.mensagemErro("Preencha o campo senha");
      return false;
    }

    return true;
  }

  private validarRegistroCandidato(candidato: Candidato): boolean {

    if (this.appService.isNullOrUndefined(candidato.nome)) {
      this.appService.mensagemErro("Preencha o nome");
      return false;
    }

    if (this.appService.isNullOrUndefined(candidato.cep)) {
      this.appService.mensagemErro("Preencha o CEP");
      return false;
    }

    if (!this.validarCEP(candidato.cep)) {
      this.appService.mensagemErro("CEP inválido");
      return false;
    }

    if (this.appService.isNullOrUndefined(candidato.cargo)) {
      this.appService.mensagemErro("Selecione um cargo");
      return false;
    }

    if (this.appService.isNullOrUndefined(candidato.email)) {
      this.appService.mensagemErro("Preencha o email");
      return false;
    }

    if (this.appService.isNullOrUndefined(candidato.senha)) {
      this.appService.mensagemErro("Preencha o campo senha");
      return false;
    }

    return true;
  }

  irParaTabRegistrar() {
    this.tabGroup.selectedIndex = 1;
  }

  validarCEP(cep: string): boolean {
    if (this.appService.isNullOrUndefined(cep)) {
      return false;
    }
    if (cep.length === 8) {
      this.validaCepService.validarCep(cep).subscribe({
        next: (data) => {
          if (data.erro) {
            this.appService.mensagemErro("CEP inválido!");
            // this.cep.setErrors({'incorrect': true});
            return false;
          }
          return true;
        },
        error: (err) => {
          console.error(err);
        },
        complete: () => {

        }
      })
    }
    return false;
  }

}
