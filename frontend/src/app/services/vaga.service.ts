import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';

import { Vaga } from '../models/vaga.model';
import { environment } from './../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VagaService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient, private _snack: MatSnackBar) { }

  getListaPaginada(page: number = 0, size: number = 5, nome: string = ""): Observable<any> {
    let url = `${this.baseUrl}/vagas?page=${page}&size=${size}`;
    if (nome !== "") {
      url += `&nome=${nome}`;
    }
    return this.http.get(url);
  }

  getSomenteEstagios(): Observable<any> {
    const url = `${this.baseUrl}/vagas/somente-vagas-estagio`;
    return this.http.get(url);
  }

  getDados(idVaga: number) {
    const url = `${this.baseUrl}/vagas/${idVaga}`;
    return this.http.get<Vaga>(url);
  }

  getNumeroVagas(): Observable<any> {
    const url = `${this.baseUrl}/vagas/numero-vagas`;
    return this.http.get(url);
  }

  // findById(id: string): Observable<Categoria>{
  //   const url = `${this.baseUrl}/categorias/${id}`;
  //   return this.http.get<Categoria>(url);
  // }

  // create(categoria: Categoria): Observable<Categoria>{
  //   const url = `${this.baseUrl}/categorias`;
  //   return this.http.post<Categoria>(url, categoria);
  // }

  // update(categoria: Categoria): Observable<void>{
  //   const url = `${this.baseUrl}/categorias/${categoria.id}`;
  //   return this.http.put<void>(url, categoria);
  // }

  // delete(id: string): Observable<void>{
  //   const url = `${this.baseUrl}/categorias/${id}`;
  //   return this.http.delete<void>(url);
  // }

  mensagem(str: string){
    this._snack.open(`${str}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 3000
    })
  }
}
