import { Router } from '@angular/router';
import { VagaService } from './../../../services/vaga.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private vagaService: VagaService,
    private router: Router) { }

  public numeroVagas: number;
  public palavraChave: string;
  public localizacao: string;

  ngOnInit(): void {
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
