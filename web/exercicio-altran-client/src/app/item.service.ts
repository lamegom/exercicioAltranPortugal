import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private baseUrl = 'http://localhost:8080/api/v1/items';

  constructor(private http: HttpClient) { }

  getItem(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createItem(item: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, item);
  }

  updateItem(id: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteItem(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getItemsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}