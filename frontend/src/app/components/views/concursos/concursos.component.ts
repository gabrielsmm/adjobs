import { ConcursoService } from './../../../services/concurso.service';
import { Concurso } from './../../../models/Concurso.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-concursos',
  templateUrl: './concursos.component.html',
  styleUrls: ['./concursos.component.css']
})
export class ConcursosComponent implements OnInit {

  displayedColumns: string[] = ['cedente', 'prazo', 'vagas', 'salario', 'escolaridade', 'local', 'estado', 'action'];
  public concursos: Concurso[] = [];

  constructor(private concursoService: ConcursoService) { }

  ngOnInit(): void {
    this.getLista();
  }

  getLista() {
    const _this = this;
    this.concursoService.getLista().subscribe({
      next(data) {
        _this.concursos = data;
      },
      error(msg) {
        console.log('Error', msg);
      },
      complete() {

      }
    });
  }

}
