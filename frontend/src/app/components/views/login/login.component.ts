import { UsuarioService } from '../../../services/usuario.service';
import { Usuario } from './../../../models/Usuario.model';
import { AppService } from './../../../app.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuarioLogin: Usuario = new Usuario();
  showPassword: boolean = false;

  constructor(private router: Router,
    private appService: AppService,
    private usuarioService: UsuarioService) { }

  ngOnInit(): void {
  }

  realizarLogin() {
    if (!this.validarDados(this.usuarioLogin)) {
      return;
    }
    this.usuarioService.login(this.usuarioLogin).subscribe((resposta) => {
      this.usuarioService.usuarioAutenticado = true;
      this.usuarioService.objUsuarioAutenticado = resposta;
      localStorage.setItem("token", this.usuarioService.objUsuarioAutenticado.token);
      if (this.usuarioService.objUsuarioAutenticado.tipoUsuario == 1) { //EMPRESA
        this.router.navigate(['empresa/area']);
      } else if (this.usuarioService.objUsuarioAutenticado.tipoUsuario == 2) { //CANDIDATO
        this.router.navigate(['candidato/area']);
      }
    }, err => {
      if(!this.appService.isNullOrUndefined(err.error.errors)){
        for(let i = 0; i < err.error.errors.length; i++){
          this.appService.mensagemErro(err.error.errors[i].message);
        }
      } else if (!this.appService.isNullOrUndefined(err.error.error)) {
        this.appService.mensagemErro(err.error.error);
      } else {
        this.appService.mensagemErro("Houve um erro de conexão, por favor tente novamente.");
      }
    });
  }

  password() {
    this.showPassword = !this.showPassword;
  }

  private validarDados(entidadeLogin: Usuario): boolean {

    if (this.appService.isNullOrUndefined(entidadeLogin.email)) {
      this.appService.mensagemErro("Informe o e-mail");
      return false;
    }

    if (this.appService.isNullOrUndefined(entidadeLogin.senha)) {
      this.appService.mensagemErro("Informe a senha");
      return false;
    }

    return true;
  }

}
