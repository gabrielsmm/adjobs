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

  findById(id: any): Observable<Empresa>{
    const url = `${this.baseUrl}/empresas/${id}`;
    return this.http.get<Empresa>(url);
  }

  getLista(): Observable<any> {
    const url = `${this.baseUrl}/empresas`;
    return this.http.get(url);
  }

  create(empresa: Empresa): Observable<Empresa>{
    const url = `${this.baseUrl}/empresas`;
    return this.http.post<Empresa>(url, empresa);
  }

  update(empresa: Empresa): Observable<Empresa>{
    const url = `${this.baseUrl}/empresas/${empresa.id}`;
    return this.http.put<Empresa>(url, empresa);
  }

  // delete(id: string): Observable<void>{
  //   const url = `${this.baseUrl}/categorias/${id}`;
  //   return this.http.delete<void>(url);
  // }
}
