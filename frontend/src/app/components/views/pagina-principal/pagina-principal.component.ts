import { Vaga } from '../../../models/vaga.model';
import { VagaService } from './../../../services/vaga.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-principal',
  templateUrl: './pagina-principal.component.html',
  styleUrls: ['./pagina-principal.component.css']
})
export class PaginaPrincipalComponent implements OnInit {

  public vagas: Vaga[] = [];

  constructor(private vagaService: VagaService) { }

  ngOnInit(): void {
    this.getListaPaginada();
  }

  getListaPaginada() {
    const _this = this;
    this.vagaService.getListaPaginada().subscribe({
      next(data) {
        _this.vagas = data['content'];
      },
      error(msg) {
        console.log('Error', msg);
      },
      complete() {

      }
     });
  }

}
