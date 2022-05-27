import { Router, NavigationEnd } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-area-candidato',
  templateUrl: './area-candidato.component.html',
  styleUrls: ['./area-candidato.component.css']
})
export class AreaCandidatoComponent implements OnInit {

  public isArea: boolean = false;
  public isCandidaturas: boolean = false;
  public isCurriculo: boolean = false;

  constructor(private router: Router) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        switch (event.url) {
          case '/candidato/area':
            this.isArea = true;
            this.isCandidaturas = false;
            this.isCurriculo = false;
            break;
          case '/candidato/candidaturas':
            this.isCandidaturas = true;
            this.isArea = false;
            this.isCurriculo = false;
            break;
          case '/candidato/curriculo':
            this.isCurriculo = true;
            this.isCandidaturas = false;
            this.isArea = false;
            break;
          default:
            this.isArea = true;
            this.isCandidaturas = false;
            this.isCurriculo = false;
        }
      }
    });
   }

  ngOnInit(): void {

  }

}
