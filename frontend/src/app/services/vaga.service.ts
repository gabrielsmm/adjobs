import { Vaga } from './../models/vaga.model';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class VagaService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient, private _snack: MatSnackBar) { }

  getListaPaginada(): Observable<any> {
    const url = `${this.baseUrl}/vagas?page=0&size=5&sort=id,desc`;
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

  // mensagem(str: string){
  //   this._snack.open(`${str}`, 'OK', {
  //     horizontalPosition: 'end',
  //     verticalPosition: 'top',
  //     duration: 3000
  //   })
  // }
}
