import { VagaService } from './../../../services/vaga.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private vagaService: VagaService) { }

  public numeroVagas: number;

  ngOnInit(): void {
    this.obterNumeroVagas();
  }

  private obterNumeroVagas() {
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

}
