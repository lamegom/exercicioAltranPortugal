import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from '@angular/router';
import { Pedido } from '../pedido';
import { Observable } from "rxjs";
import { PedidoService } from "../pedido.service";

@Component({
  selector: 'app-carrinho-list',
  templateUrl: './carrinho-list.component.html',
  styleUrls: ['./carrinho-list.component.css']
})
export class CarrinhoListComponent implements OnInit {

  pedidos: Observable<Pedido[]>;

  constructor(private pedidoService: PedidoService,
    private route: ActivatedRoute,private router: Router,) {}

  ngOnInit() {

    var id = this.route.snapshot.params['id'];
    
    console.log(id)

    this.pedidoService.getPedidos(id)
      .subscribe(data => {
        var pedidos = data;

        for (var j = 0; j < pedidos.length; j++) {
          let pedido = pedidos[j];
          pedido.total = 0;
          for (var i = 0; i < pedido.items.length; i++) {
            let itemCarrinho = pedido.items[i];
            pedido.total += itemCarrinho.item.valor * itemCarrinho.quantidade;
          }

          
        }




        this.pedidos = pedidos.sort(this.compareByAmount);
      }, error => console.log(error));
  }

  compareByAmount(a : any, b : any) : any {
     
    const amountA = a.total;
    const amountB = b.total;
  
    let comparison = 0;
    if (amountA > amountB) {
      comparison = 1;
    } else if (amountA < amountB) {
      comparison = -1;
    }
    return comparison;
  }

}
