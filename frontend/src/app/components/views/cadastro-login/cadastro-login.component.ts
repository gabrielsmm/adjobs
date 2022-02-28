import { EmpresaService } from './../../../services/empresa.service';
import { Empresa } from './../../../models/Empresa.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './cadastro-login.component.html',
  styleUrls: ['./cadastro-login.component.css']
})
export class CadastroLoginComponent implements OnInit {

  empresa: Empresa = {
    nome: '',
    cnpj: '',
    qtdFuncionarios: 0,
    cep: '',
    nomeResponsavel: '',
    telefone: '',
    celular: '',
    email: '',
    senha: ''
  };

  constructor(private empresaService: EmpresaService) { }

  ngOnInit(): void {
  }

  registrar() {
    if (!this.validarRegistro(this.empresa)) {
      return;
    }
    let _this = this;
    this.empresaService.create(this.empresa).subscribe({
      next(data) {
        _this.empresaService.mensagem("Registro realizado com sucesso!");
        console.log(data);
      },
      error(err) {
        console.log(err);
        for(let i = 0; i < err.error.errors.length; i++){
          _this.empresaService.mensagem(err.error.errors[i].message);
        }
      },
      complete() {

      }
    });
  }

  private validarRegistro(empresa: Empresa): boolean {

    if (empresa.nome === null || empresa.nome === undefined || empresa.nome === '') {
      this.empresaService.mensagem("Preencha o nome da empresa");
      return false;
    }

    return true;
  }
}
