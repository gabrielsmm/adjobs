import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from './../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  baseUrl: string = environment.baseUrl;

  constructor(private http: HttpClient) { }

  sendMail(email: any): Observable<any>{
    const url = `${this.baseUrl}/email/send/${email}`;
    return this.http.get(url);
  }

}
