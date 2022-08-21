import { Router } from '@angular/router';
import { Usuario } from '../models/Usuario.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  baseUrl: string = environment.baseUrl;

  public usuarioAutenticado: boolean = false;
  public objUsuarioAutenticado: Usuario | any;

  constructor(private http: HttpClient,
    private router: Router) { }

  login(usuario: Usuario): Observable<Usuario>{
    const url = `${this.baseUrl}/usuarios/login`;
    return this.http.post<Usuario>(url, usuario);
  }

  alterarSenha(id: number, senha: string) {
    const url = `${this.baseUrl}/usuarios/${id}?senha=${senha}`;
    return this.http.patch<void>(url, null);
  }

  deslogar() {
    this.usuarioAutenticado = false;
    this.objUsuarioAutenticado = null;
    localStorage.removeItem('token');
    this.router.navigate(['inicio']);
  }

}
