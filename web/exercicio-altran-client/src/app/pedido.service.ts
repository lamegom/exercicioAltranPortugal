import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  private baseUrl = 'http://localhost:8080/api/v1/pedidos';

  constructor(private http: HttpClient) { }

  getPedidos(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createPedido(pedido: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, pedido);
  }

  saveItems(itemCarrinho: Object[]): Observable<Object> {
    return this.http.post(`${this.baseUrl}/itemsCompra`, itemCarrinho);
  }

  

}