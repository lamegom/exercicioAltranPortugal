import { UsuarioDetailsComponent } from '../usuario-details/usuario-details.component';
import { Observable } from "rxjs";
import { UsuarioService } from "../usuario.service";
import { PedidoService } from "../pedido.service";
import { Usuario } from "../usuario";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import { Pedido } from '../pedido';
import { ItemCarrinho } from '../itemCarrinho';

@Component({
  selector: 'app-carrinho-usuario',
  templateUrl: './carrinho-usuario.component.html',
  styleUrls: ['./carrinho-usuario.component.css']
})
export class CarrinhoUsuarioComponent implements OnInit {

  usuarios: Observable<Usuario[]>;

  constructor(private usuarioService: UsuarioService, private pedidoService: PedidoService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.usuarios = this.usuarioService.getUsuariosList();
  }


fechar(id: string) {

    
  this.usuarioService.getUsuario(JSON.stringify(id))
    .subscribe(data => {
      console.log(data)
      var usuario = data;

      var itemsCarrinho = [];
      let cart = JSON.parse(localStorage.getItem('cart'));
      for (var i = 0; i < cart.length; i++) {
        let itemCarrinho = JSON.parse(cart[i]);
        itemsCarrinho.push({
          item: itemCarrinho.item,
          quantity: itemCarrinho.quantity
        });
      }



        var pedido: Pedido = {
          usuario : usuario,
          items : itemsCarrinho,
          id: null
 
       }

       this.pedidoService.createPedido(pedido).subscribe(ped => {
         console.log('persited: ', ped);
 
         this.router.navigate(['pedidos', JSON.stringify(id)]);
     }, error => console.log(error))


      



    }, error => console.log(error))

}

}
