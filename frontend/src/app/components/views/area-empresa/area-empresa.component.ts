import { Router, NavigationEnd } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-area-empresa',
  templateUrl: './area-empresa.component.html',
  styleUrls: ['./area-empresa.component.css']
})
export class AreaEmpresaComponent implements OnInit {

  public isArea: boolean = false;
  public isVagas: boolean = false;

  constructor(private router: Router) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        switch (event.url) {
          case '/empresa/area':
            this.isArea = true;
            this.isVagas = false;
            break;
          case '/empresa/vagas':
            this.isVagas = true;
            this.isArea = false;
            break;
          default:
            this.isArea = true;
            this.isVagas = false;
        }
      }
    });
   }

  ngOnInit(): void {
  }

}
