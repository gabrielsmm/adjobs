import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  show: boolean = false;
  public isHome: boolean = false;
  public isEmpregos: boolean = false;
  public isEstagios: boolean = false;
  public isConcursos: boolean = false;
  public isLogin: boolean = false;

  constructor(private router: Router) { }

  ngOnInit(): void {
    switch (this.router.url) {
      case '/empregos':
        this.isEmpregos = true;
        break;
      case '/estagios':
        this.isEstagios = true;
        break;
      case '/concursos':
        this.isConcursos = true;
        break;
      case '/inicio':
        this.isHome = true;
        break;
      case '/login':
        this.isLogin = true;
        break;
    }
  }

  navegar(rota: string) {
    this.router.navigate([rota]);
  }

  showCollapse() {
    this.show = !this.show;
  }

}
