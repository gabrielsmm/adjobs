import { AppService } from './../../../app.service';
import { EmpresaService } from './../../../services/empresa.service';
import { Empresa } from './../../../models/Empresa.model';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTabGroup } from '@angular/material/tabs';

@Component({
  selector: 'app-login',
  templateUrl: './cadastro-login.component.html',
  styleUrls: ['./cadastro-login.component.css']
})
export class CadastroLoginComponent implements OnInit {

  @ViewChild('tabs') tabGroup: MatTabGroup;

  public empresa: Empresa = new Empresa();

  constructor(private empresaService: EmpresaService,
    private appService: AppService) { }

  ngOnInit(): void {
  }

  registrar() {
    if (!this.validarRegistro(this.empresa)) {
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
        for(let i = 0; i < err.error.errors.length; i++){
          _this.appService.mensagem(err.error.errors[i].message);
        }
      },
      complete() {

      }
    });
  }

  private validarRegistro(empresa: Empresa): boolean {

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

  irParaTabRegistrar() {
    this.tabGroup.selectedIndex = 1;
  }
}
