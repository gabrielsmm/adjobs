import { Injectable } from '@angular/core';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { Location } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  tiposContratacao = [
    {value: 0, viewValue: 'Temporário'},
    {value: 1, viewValue: 'Parcial'},
    {value: 2, viewValue: 'Estágio'},
    {value: 3, viewValue: 'Jovem Aprendiz'},
    {value: 4, viewValue: 'Terceirizado'},
    {value: 5, viewValue: 'Home Office'},
    {value: 6, viewValue: 'Intermitente'},
  ];

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
}
