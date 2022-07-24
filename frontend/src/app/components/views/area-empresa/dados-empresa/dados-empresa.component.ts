import { Component, OnInit } from '@angular/core';

import { AppService } from './../../../../app.service';
import { Empresa } from './../../../../models/Empresa.model';
import { EmpresaService } from './../../../../services/empresa.service';
import { LoginService } from './../../../../services/login.service';
import { ValidaCepService } from './../../../../services/validaCep.service';

@Component({
  selector: 'app-dados-empresa',
  templateUrl: './dados-empresa.component.html',
  styleUrls: ['./dados-empresa.component.css']
})
export class DadosEmpresaComponent implements OnInit {

  public empresa: Empresa = new Empresa();
  public isEditavel: boolean = false;

  constructor(private empresaService: EmpresaService,
    private loginService: LoginService,
    public appService: AppService,
    private validaCepService: ValidaCepService) { }

  ngOnInit(): void {
    this.getDadosEmpresa();
  }

  getDadosEmpresa() {
    this.empresaService.findById(this.loginService.objUsuarioAutenticado.id).subscribe({
      next: (data) => {
        this.empresa = data;
      },
      error: (msg) => {
        this.appService.mensagemErro('Erro ao buscar os dados da empresa');
        console.log(msg);
      },
      complete: () => {

      }
    })
  }

  editarClick() {
    if (!this.isEditavel) {
      this.isEditavel = true;
    }
  }

  salvarClick() {
    this.empresaService.update(this.empresa).subscribe({
      next: (data) => {
        if (!this.appService.isNullOrUndefined(data)) {
          this.appService.mensagemSucesso("Dados salvos");
          this.isEditavel = false;
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
            this.empresa.estado = data.uf;
            this.empresa.cidade = data.localidade;
            this.empresa.bairro = data.bairro;
            this.empresa.rua = data.logradouro;
            this.empresa.complemento = data.complemento;
          }
        },
        error: (err) => {

        },
        complete: () => {

        }
      })
    }
  }

}
