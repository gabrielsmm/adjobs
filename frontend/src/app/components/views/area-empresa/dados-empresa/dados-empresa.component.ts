import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { UsuarioService } from '../../../../services/usuario.service';
import { AppService } from './../../../../app.service';
import { Empresa } from './../../../../models/Empresa.model';
import { EmpresaService } from './../../../../services/empresa.service';
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
    private usuarioService: UsuarioService,
    public appService: AppService,
    private validaCepService: ValidaCepService,
    private router: Router) { }

  ngOnInit(): void {
    this.getDadosEmpresa();
  }

  getDadosEmpresa() {
    this.empresaService.findById(this.usuarioService.objUsuarioAutenticado.id).subscribe({
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
          this.appService.mensagemSucesso("Dados salvos com sucesso!");
          this.isEditavel = false;
          this.router.navigate(['empresa/area']);
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
