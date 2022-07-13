import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Vaga } from '../models/Vagas.model';
import { environment } from './../../environments/environment';
import { AppService } from './../app.service';

export class Filtro {
  public pesquisa: string;
  public tipo: number;
  public palavraChave: string;
  public localizacao: string;
}

@Injectable({
  providedIn: 'root'
})
export class VagaService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient,
  private appService: AppService) { }

  getListaPaginada(page: number = 0, size: number = 5, filtro: Filtro): Observable<any> {
    let url = `${this.baseUrl}/vagas?page=${page}&size=${size}`;
    if (!this.appService.isNullOrUndefined(filtro.pesquisa)) {
      url += `&nome=${filtro.pesquisa}`;
    } else if (!this.appService.isNullOrUndefined(filtro.tipo) && filtro.tipo >= 0) {
      url += `&tipo=${filtro.tipo}`;
    } else if (!this.appService.isNullOrUndefined(filtro.palavraChave) &&
               !this.appService.isNullOrUndefined(filtro.localizacao)) {
      url += `&palavraChave=${filtro.palavraChave}&localizacao=${filtro.localizacao}`;
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

  getNumeroVagasPorEmpresa(idEmpresa: number): Observable<any> {
    const url = `${this.baseUrl}/vagas/numero-vagas/${idEmpresa}`;
    return this.http.get(url);
  }

  findAllByEmpresa(idEmpresa: number): Observable<any> {
    const url = `${this.baseUrl}/vagas/empresa/${idEmpresa}`;
    return this.http.get(url);
  }

  save(vaga: Vaga): Observable<Vaga>{
    if (this.appService.isNullOrUndefined(vaga.id)) {
      const url = `${this.baseUrl}/vagas`;
      return this.http.post<Vaga>(url, vaga);
    } else {
      const url = `${this.baseUrl}/vagas/${vaga.id}`;
      return this.http.put<Vaga>(url, vaga);
    }
  }

  delete(id: number): Observable<void>{
    const url = `${this.baseUrl}/vagas/${id}`;
    return this.http.delete<void>(url);
  }

  getContador(idEmpresa: number): Observable<any> {
    const url = `${this.baseUrl}/vagas/contador/${idEmpresa}`;
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
}
