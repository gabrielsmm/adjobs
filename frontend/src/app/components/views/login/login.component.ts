import { LoginService } from './../../../services/login.service';
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

  constructor(private router: Router,
    private appService: AppService,
    private loginService: LoginService) { }

  ngOnInit(): void {
  }

  irParaCadastro() {
    this.router.navigate(['/cadastro']);
  }

  realizarLogin() {
    console.log('verificando login...');
    if (!this.validarDados(this.usuarioLogin)) {
      return;
    }
    this.loginService.login(this.usuarioLogin).subscribe((resposta) => {
      this.loginService.usuarioAutenticado = true;
      this.loginService.objUsuarioAutenticado = resposta;
      // this.router.navigate(['home']);
      this.appService.mensagem("Logado com sucesso!");
    }, err => {
      if(err.error.errors !== undefined){
        for(let i = 0; i < err.error.errors.length; i++){
          this.appService.mensagem(err.error.errors[i].message);
        }
      } else {
        this.appService.mensagem("Usuário ou senha incorretos!");
      }
    });
  }

  private validarDados(entidadeLogin: Usuario): boolean {

    if (this.appService.isNullOrUndefined(entidadeLogin.email)) {
      this.appService.mensagem("Informe o e-mail");
      return false;
    }

    if (this.appService.isNullOrUndefined(entidadeLogin.senha)) {
      this.appService.mensagem("Informe a senha");
      return false;
    }

    return true;
  }

}
