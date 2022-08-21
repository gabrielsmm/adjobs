import { UsuarioService } from './../../../services/usuario.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  show: boolean = false;
  public isHome: boolean = false;
  public isEmpregos: boolean = false;
  // public isEstagios: boolean = false;
  // public isConcursos: boolean = false;
  public isCadastro: boolean = false;
  public isLogin: boolean = false;
  public isAreaCandidato: boolean = false;
  public isAreaEmpresa: boolean = false;

  constructor(private router: Router,
    public usuarioService: UsuarioService) { }

  ngOnInit(): void {
    switch (this.router.url) {
      case '/empregos':
        this.isEmpregos = true;
        break;
      case '/inicio':
        this.isHome = true;
        break;
      case '/cadastro':
        this.isCadastro = true;
        break;
      case '/login':
        this.isLogin = true;
        break;
      default:
        if (this.router.url.includes('/candidato')) {
          this.isAreaCandidato = true;
        } else if (this.router.url.includes('/empresa')) {
          this.isAreaEmpresa = true;
        } else if (this.router.url.includes('/empregos')) {
          this.isEmpregos = true;
        } else {
          this.isHome = true;
        }
    }
  }

  navegar(rota: string) {
    this.router.navigate([rota]);
  }

  showCollapse() {
    this.show = !this.show;
  }

  deslogar() {
    this.usuarioService.deslogar();
  }

}
