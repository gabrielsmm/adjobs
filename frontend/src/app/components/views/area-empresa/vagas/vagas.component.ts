import { DialogCurriculoComponent } from './../../../comuns/dialog-curriculo/dialog-curriculo.component';
import { MatDialog } from '@angular/material/dialog';
import { Curriculo } from './../../../../models/Curriculo.model';
import { CurriculoService } from './../../../../services/curriculo.service';
import { Candidatura } from './../../../../models/Candidatura.model';
import { CandidaturaService } from './../../../../services/candidatura.service';
import { EmpresaService } from './../../../../services/empresa.service';
import { AppService } from './../../../../app.service';
import { LoginService } from './../../../../services/login.service';
import { VagaService } from './../../../../services/vaga.service';
import { Vaga } from './../../../../models/vaga.model';
import { Component, OnInit } from '@angular/core';

export enum State {
  StateGrid = 1,
  StateDados = 2,
  StateCandidatos = 3
}

@Component({
  selector: 'app-vagas',
  templateUrl: './vagas.component.html',
  styleUrls: ['./vagas.component.css']
})
export class VagasComponent implements OnInit {

  public numeroVagas: number;
  public numeroVaga: number;
  public vaga: Vaga = new Vaga;
  public vagas: Vaga[] = [];
  public candidaturas: Candidatura[] = [];
  public curriculo: Curriculo;
  public state = State;
  public stateChange = State.StateGrid;
  public readMore = false;

  constructor(private vagaService: VagaService,
  private loginService: LoginService,
  public appService: AppService,
  private empresaService: EmpresaService,
  private candidaturaService: CandidaturaService,
  private curriculoService: CurriculoService,
  private dialog: MatDialog) {
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
          this.appService.mensagemSucesso("Vaga salva");
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
    this.stateChange = State.StateDados;
  }

  editarClick(vaga: Vaga) {
    this.vaga = vaga;
    this.stateChange = State.StateDados;
  }

  voltarClick() {
    this.stateChange = State.StateGrid;
  }

  exibirCandidatosClick(vaga: Vaga) {
    this.candidaturaService.findAllByVaga(vaga.id).subscribe({
      next: (data) => {
        this.candidaturas = data;
        if (this.candidaturas.length <= 0) {
          this.appService.mensagemTime("Vaga selecionada ainda não possui candidaturas.", 5000);
        } else {
          this.vaga = vaga;
          this.stateChange = State.StateCandidatos;
        }
      },
      error: (error) => {
        console.error(error);
      },
      complete: () => {

      }
    })
  }

  exibirCurriculoClick(idCandidato: any) {
    this.curriculoService.findByCandidato(idCandidato).subscribe({
      next: (data) => {
        const dialogRef = this.dialog.open(DialogCurriculoComponent, {
          data: data,
          height: '600px',
          width: '800px'
        });

        dialogRef.afterClosed().subscribe(result => {
          console.log(`Dialog fechado`);
        })
      },
      error: (error) => {
        console.error(error);
      },
      complete: () => {

      }
    })
  }

}
