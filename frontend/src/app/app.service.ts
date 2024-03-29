import { Injectable } from '@angular/core';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { Location } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  tiposContratacao = [
    {value: 0, viewValue: 'Tempo indeterminado'},
    {value: 1, viewValue: 'Temporário'},
    {value: 2, viewValue: 'Parcial'},
    {value: 3, viewValue: 'Estágio'},
    {value: 4, viewValue: 'Jovem Aprendiz'},
    {value: 5, viewValue: 'Trainee'},
    {value: 6, viewValue: 'Terceirizado'},
    {value: 7, viewValue: 'Home Office'},
    {value: 8, viewValue: 'Intermitente'},
  ];

  formacaoStatus = [
    {value: 0, viewValue: 'Concluído'},
    {value: 1, viewValue: 'Cursando'},
    {value: 2, viewValue: 'Trancado'}
  ]

  formacaoNivel = [
    {value: 0, viewValue: 'Fundamental'},
    {value: 1, viewValue: 'Médio'},
    {value: 2, viewValue: 'Extra Curricular'},
    {value: 3, viewValue: 'Técnico'},
    {value: 4, viewValue: 'Superior'},
    {value: 5, viewValue: 'Especialização'},
    {value: 6, viewValue: 'Mestrado'},
    {value: 7, viewValue: 'Doutorado'}
  ]

  constructor(private _snack: MatSnackBar, private location: Location) { }

  mensagem(str: string){
    this._snack.open(`${str}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 3000
    })
  }

  mensagemTime(str: string, duration: number){
    this._snack.open(`${str}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: duration
    })
  }

  mensagemErro(str: string){
    const config = new MatSnackBarConfig();
    config.panelClass = ['snack-background-red'];
    config.duration = 3000;
    config.horizontalPosition = 'end';
    config.verticalPosition = 'top';
    this._snack.open(`${str}`, '', config);
  }

  mensagemSucesso(str: string){
    const config = new MatSnackBarConfig();
    config.panelClass = ['snack-background-green'];
    config.duration = 3000;
    config.horizontalPosition = 'end';
    config.verticalPosition = 'top';
    this._snack.open(`${str}`, '', config);
  }

  goBack(){
    this.location.back();
  }

  isNullOrUndefined(obj: any) {
    return obj === null || obj === undefined;
  }

  keyPressNumbers(event: any) {
    var charCode = (event.which) ? event.which : event.keyCode;
    // Only Numbers 0-9
    if ((charCode < 48 || charCode > 57)) {
      event.preventDefault();
      return false;
    } else {
      return true;
    }
  }

  scrollToTop() {
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth'
    });
  }

}
