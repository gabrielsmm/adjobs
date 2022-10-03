import { Router } from '@angular/router';
import { EmailService } from './../../../services/email.service';
import { AppService } from './../../../app.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recuperacao-senha',
  templateUrl: './recuperacao-senha.component.html',
  styleUrls: ['./recuperacao-senha.component.css']
})
export class RecuperacaoSenhaComponent implements OnInit {

  public email: string;

  constructor(private appService: AppService,
    private emailService: EmailService,
    private router: Router) { }

  ngOnInit(): void {
  }

  enviarEmail() {
    if (this.appService.isNullOrUndefined(this.email)) {
      this.appService.mensagemErro("Informe o e-mail");
      return;
    }
    this.emailService.sendMail(this.email).subscribe({
      next: (data) => {
        this.appService.mensagemSucesso("Credenciais enviadas, verifique seu e-mail.");
        this.router.navigate(['/login']);
      },
      error: (err) => {
        console.error(err);
        if (!this.appService.isNullOrUndefined(err.error.error)) {
          if (!this.appService.isNullOrUndefined(err.error.message)) {
            this.appService.mensagemErro(err.error.message);
          } else if (!this.appService.isNullOrUndefined(err.error.error)) {
            this.appService.mensagemErro(err.error.error);
          }
        }
      },
      complete: () => {

      }
    })
  }

}
