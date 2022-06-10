import { EmpresaService } from './../../../../services/empresa.service';
import { AppService } from './../../../../app.service';
import { LoginService } from './../../../../services/login.service';
import { VagaService } from './../../../../services/vaga.service';
import { Vaga } from './../../../../models/vaga.model';
import { Component, OnInit } from '@angular/core';

export enum State {
  StateGrid = 1,
  StateDados = 2
}

@Component({
  selector: 'app-vagas',
  templateUrl: './vagas.component.html',
  styleUrls: ['./vagas.component.css']
})
export class VagasComponent implements OnInit {

  public numeroVagas: number;
  public vaga: Vaga = new Vaga;
  public vagas: Vaga[] = [];
  public state = State;
  public stateChange = State.StateGrid;

  tiposContratacao = [
    {value: 0, viewValue: 'Temporário'},
    {value: 1, viewValue: 'Parcial'},
    {value: 2, viewValue: 'Estágio'},
    {value: 3, viewValue: 'Jovem Aprendiz'},
    {value: 4, viewValue: 'Terceirizado'},
    {value: 5, viewValue: 'Home Office'},
    {value: 6, viewValue: 'Intermitente'},
  ];

  constructor(private vagaService: VagaService,
  private loginService: LoginService,
  public appService: AppService,
  private empresaService: EmpresaService) {
    this.getNumeroVagas();
    this.getVagas();
  }

  ngOnInit(): void {
  }

  getVagas() {
    this.vagaService.findAllByEmpresa(this.loginService.objUsuarioAutenticado.id).subscribe({
      next: (data) => {
        this.vagas = data;
      },
      error: (msg) => {
        console.log('Error', msg);
      },
      complete: () => {

      }
    })
  }

  getNumeroVagas() {
    this.vagaService.getNumeroVagasPorEmpresa(this.loginService.objUsuarioAutenticado.id).subscribe({
      next: (data) => {
        this.numeroVagas = data;
      },
      error: (msg) => {
        console.log('Error', msg);
      },
      complete: () => {

      }
    });
  }

  salvarVagaClick() {
    this.vagaService.save(this.vaga).subscribe({
      next: (data) => {
        if (!this.appService.isNullOrUndefined(data)) {
          this.appService.mensagem("Vaga salva");
          this.stateChange = State.StateGrid;
          this.getVagas();
        }
      },
      error: (error) => {
        console.error(error);
      },
      complete: () => {

      }
    })
  }

  cadastrarVagaClick() {
    this.vaga = new Vaga;
    this.empresaService.findById(this.loginService.objUsuarioAutenticado.id).subscribe({
      next: (data) => {
        this.vaga.empresa = data;
      }
    })
    console.log(this.vaga);
    this.stateChange = State.StateDados;
  }

  editarClick(vaga: Vaga) {
    this.vaga = vaga;
    this.stateChange = State.StateDados;
  }

  voltarClick() {
    this.stateChange = State.StateGrid;
  }

}
