import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

import { AppService } from './../../../../app.service';
import { Candidatura } from './../../../../models/Candidatura.model';
import { Curriculo } from './../../../../models/Curriculo.model';
import { Vaga } from './../../../../models/vaga.model';
import { CandidaturaService } from './../../../../services/candidatura.service';
import { CurriculoService } from './../../../../services/curriculo.service';
import { EmpresaService } from './../../../../services/empresa.service';
import { LoaderService } from './../../../../services/loader.service';
import { LoginService } from './../../../../services/login.service';
import { VagaService } from './../../../../services/vaga.service';
import { DialogConfirmacaoComponent } from './../../../comuns/dialog-confirmacao/dialog-confirmacao.component';
import { DialogCurriculoComponent } from './../../../comuns/dialog-curriculo/dialog-curriculo.component';

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

  public dialogRef: MatDialogRef<DialogConfirmacaoComponent>;
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
  private dialog: MatDialog,
  public loaderService: LoaderService) {
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
          this.appService.mensagemSucesso("Vaga salva com sucesso!");
          this.stateChange = State.StateGrid;
          this.getVagas();
        }
      },
      error: (error) => {
        if (!this.appService.isNullOrUndefined(error.error.error)) {
          this.appService.mensagemErro(`${error.error.error}, por favor preencha os campos corretamente!`);
        }
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
          this.appService.mensagemErro("Vaga selecionada ainda não possui candidaturas.");
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

  excluirClick(vaga: Vaga) {
    this.dialogRef = this.dialog.open(DialogConfirmacaoComponent, {
      disableClose: false
    });
    this.dialogRef.componentInstance.confirmMessage = `Realmente deseja excluir a vaga vaga ${vaga.id} - ${vaga.nome}?`

    this.dialogRef.afterClosed().subscribe(result => {
      if(result) {
        this.vagaService.delete(vaga.id).subscribe({
          next: (data) => {
            this.appService.mensagemSucesso("Vaga deletada com sucesso!");
            this.getNumeroVagas();
            this.getVagas();
          },
          error: (error) => {
            if (!this.appService.isNullOrUndefined(error.error.error)) {
              this.appService.mensagemErro(error.error.error);
            }
          },
          complete: () => {

          }
        })
      }
    });
  }

  atualizarStatus(candidatura: Candidatura) {

  }

}
