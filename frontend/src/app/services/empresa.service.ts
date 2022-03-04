import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from './../../environments/environment';
import { Empresa } from './../models/Empresa.model';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) { }

  getLista(): Observable<any> {
    const url = `${this.baseUrl}/empresas`;
    return this.http.get(url);
  }

  create(empresa: Empresa): Observable<Empresa>{
    const url = `${this.baseUrl}/empresas`;
    return this.http.post<Empresa>(url, empresa);
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
