import { AppService } from './../app.service';
import { Curriculo } from './../models/Curriculo.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from './../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CurriculoService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient,
    private appService: AppService) { }

  getLista(): Observable<any> {
    const url = `${this.baseUrl}/curriculos`;
    return this.http.get(url);
  }

  findByCandidato(idCandidato: number): Observable<any> {
    const url = `${this.baseUrl}/curriculos/candidato/${idCandidato}`;
    return this.http.get(url);
  }

  save(curriculo: Curriculo): Observable<Curriculo>{
    if (this.appService.isNullOrUndefined(curriculo.id)) {
      const url = `${this.baseUrl}/curriculos`;
      return this.http.post<Curriculo>(url, curriculo);
    } else {
      const url = `${this.baseUrl}/curriculos/${curriculo.id}`;
      return this.http.put<Curriculo>(url, curriculo);
    }
  }

  // update(curriculo: Curriculo): Observable<void>{
  //   const url = `${this.baseUrl}/curriculos/${curriculo.id}`;
  //   return this.http.put<void>(url, curriculo);
  // }

  // findById(id: string): Observable<Categoria>{
  //   const url = `${this.baseUrl}/categorias/${id}`;
  //   return this.http.get<Categoria>(url);
  // }

  // delete(id: string): Observable<void>{
  //   const url = `${this.baseUrl}/categorias/${id}`;
  //   return this.http.delete<void>(url);
  // }
}
