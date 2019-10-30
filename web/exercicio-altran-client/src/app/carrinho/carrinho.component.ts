import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from "rxjs";
import { ItemService } from "../item.service";
import { Item } from "../item";
import { ItemCarrinho } from "../itemCarrinho";

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit {


  private itemsCarrinho: ItemCarrinho[] = [];
  private total: number = 0;


  constructor(private route: ActivatedRoute,private router: Router,
     private itemService: ItemService) { }

     ngOnInit() {
      this.route.params.subscribe(params => {
       // var id = params['id'];
        var id = this.route.snapshot.params['id'];
        if (id) {
          var itemCarrinho: ItemCarrinho 
          this.itemService.getItem(id).subscribe(data => {
            
            itemCarrinho= {
              item: data,
              quantity: 1
            };

            if (localStorage.getItem('cart') == null) {
              let cart: any = [];
              cart.push(JSON.stringify(itemCarrinho));
              localStorage.setItem('cart', JSON.stringify(cart));
            } else {
              let cart: any = JSON.parse(localStorage.getItem('cart'));
              let index: number = -1;
              for (var i = 0; i < cart.length; i++) {
                let itemCarrinho: ItemCarrinho = JSON.parse(cart[i]);
                if (this.isEquivalent(itemCarrinho.item.id, JSON.parse(id))) {
                  index = i;
                  break;
                }
              }
              console.log('index: ', index)
              if (index == -1) {
                cart.push(JSON.stringify(itemCarrinho));
                localStorage.setItem('cart', JSON.stringify(cart));
              } else {
                let itemCarrinho: ItemCarrinho = JSON.parse(cart[index]);
                itemCarrinho.quantity += 1;
                cart[index] = JSON.stringify(itemCarrinho);
                localStorage.setItem("cart", JSON.stringify(cart));
              }
            }

            this.loadCart();

          }, error => console.log(error))



          

          
        } else {
          this.loadCart();
        }
      });
    }
  
    loadCart(): void {
      this.total = 0;
      this.itemsCarrinho = [];
      let cart = JSON.parse(localStorage.getItem('cart'));
      for (var i = 0; i < cart.length; i++) {
        let itemCarrinho = JSON.parse(cart[i]);
        this.itemsCarrinho.push({
          item: itemCarrinho.item,
          quantity: itemCarrinho.quantity
        });
        this.total += itemCarrinho.item.valor * itemCarrinho.quantity;
      }
      console.log('this.itemsCarrinho ', this.itemsCarrinho )
    }
  
    remove(id: string): void {
      let cart: any = JSON.parse(localStorage.getItem('cart'));
      let index: number = -1;
      for (var i = 0; i < cart.length; i++) {
        let itemCarrinho: ItemCarrinho = JSON.parse(cart[i]);

        if (this.isEquivalent(itemCarrinho.item.id, id)) {
          cart.splice(i, 1);
          break;
        }
      }
      localStorage.setItem("cart", JSON.stringify(cart));
      this.loadCart();
    }

    isEquivalent(a: any, b: any): boolean {
      // Create arrays of property names
      var aProps = Object.getOwnPropertyNames(a);
      var bProps = Object.getOwnPropertyNames(b);
  
      // If number of properties is different,
      // objects are not equivalent
      if (aProps.length != bProps.length) {
          return false;
      }
  
      for (var i = 0; i < aProps.length; i++) {
          var propName = aProps[i];
  
          // If values of same property are not equal,
          // objects are not equivalent
          if (a[propName] !== b[propName]) {
              return false;
          }
      }
  
      // If we made it this far, objects
      // are considered equivalent
      return true;
  }

  itemDetails(id: string){
    this.router.navigate(['details', JSON.stringify(id)]);
  }

  fecharPedido(){
    this.router.navigate(['carrinho-usuario']);
  }

}
