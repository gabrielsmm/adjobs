import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from './../../environments/environment';
import { Candidato } from './../models/Candidato.model';

@Injectable({
  providedIn: 'root'
})
export class CandidatoService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) { }

  getLista(): Observable<any> {
    const url = `${this.baseUrl}/candidatos`;
    return this.http.get(url);
  }

  create(candidato: Candidato): Observable<Candidato>{
    const url = `${this.baseUrl}/candidatos`;
    return this.http.post<Candidato>(url, candidato);
  }

  // findById(id: string): Observable<Categoria>{
  //   const url = `${this.baseUrl}/categorias/${id}`;
  //   return this.http.get<Categoria>(url);
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
