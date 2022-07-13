import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from './../../environments/environment';
import { Candidatura } from './../models/Candidatura.model';

@Injectable({
  providedIn: 'root'
})
export class CandidaturaService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) { }

  create(idCandidato: number, idVaga: number) {
    const url = `${this.baseUrl}/candidaturas/candidatar/${idCandidato}/${idVaga}`;
    return this.http.get<Candidatura>(url);
  }

  update(candidatura: Candidatura): Observable<Candidatura>{
    const url = `${this.baseUrl}/candidaturas/${candidatura.id}`;
    return this.http.put<Candidatura>(url, candidatura);
  }

  findById(id: any): Observable<Candidatura>{
    const url = `${this.baseUrl}/candidaturas/${id}`;
    return this.http.get<Candidatura>(url);
  }

  findAllByCandidato(idCandidato: number): Observable<any> {
    const url = `${this.baseUrl}/candidaturas/candidato/${idCandidato}`;
    return this.http.get(url);
  }

  findAllByVaga(idVaga: number): Observable<any> {
    const url = `${this.baseUrl}/candidaturas/vaga/${idVaga}`;
    return this.http.get(url);
  }

  getLista(): Observable<any> {
    const url = `${this.baseUrl}/candidaturas`;
    return this.http.get(url);
  }

  getNumeroCandidaturas(idCandidato: number): Observable<any> {
    const url = `${this.baseUrl}/candidaturas/numero-candidaturas/${idCandidato}`;
    return this.http.get(url);
  }

  getContador(idCandidato: number): Observable<any> {
    const url = `${this.baseUrl}/candidaturas/contador/${idCandidato}`;
    return this.http.get(url);
  }

  // create(candidato: Candidato): Observable<Candidato>{
  //   const url = `${this.baseUrl}/candidatos`;
  //   return this.http.post<Candidato>(url, candidato);
  // }

  // delete(id: string): Observable<void>{
  //   const url = `${this.baseUrl}/categorias/${id}`;
  //   return this.http.delete<void>(url);
  // }
}
