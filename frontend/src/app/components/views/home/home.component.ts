import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AppService } from './../../../app.service';
import { VagaService } from './../../../services/vaga.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private vagaService: VagaService,
    private router: Router,
    private appService: AppService) { }

  public numeroVagas: number;
  public palavraChave: string = '';
  public localizacao: string = '';

  ngOnInit(): void {
    setTimeout(() => this.appService.scrollToTop(), 100);
    this.getNumeroVagas();
  }

  private getNumeroVagas() {
    const _this = this;
    this.vagaService.getNumeroVagas().subscribe({
      next(data) {
        _this.numeroVagas = data;
      },
      error(msg) {
        console.log('Error', msg);
      },
      complete() {

      }
    });
  }

  buscarVagasClick() {
    //validar campos
    this.router.navigate(['/empregos', this.palavraChave, this.localizacao]);
  }

}
