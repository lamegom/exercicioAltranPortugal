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
        console.log(data)
        this.pedidos = data;
      }, error => console.log(error));
  }

}
