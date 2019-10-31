import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private baseUrl = 'http://localhost:8080/api/v1/usuarios';

  constructor(private http: HttpClient) { }

  getUsuario(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getUsuarioByNome(nome: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/nome/${nome}`);
  }

  createUsuario(usuario: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, usuario);
  }

  updateUsuario(id: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteUsuario(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getUsuariosList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}