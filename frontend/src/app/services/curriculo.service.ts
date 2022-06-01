import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from './../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CurriculoService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) { }

  getLista(): Observable<any> {
    const url = `${this.baseUrl}/curriculos`;
    return this.http.get(url);
  }

  findByCandidato(idCandidato: number): Observable<any> {
    const url = `${this.baseUrl}/curriculos/candidato/${idCandidato}`;
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
}
