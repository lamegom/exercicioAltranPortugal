import { ItemService } from '../item.service';
import { Item } from '../item';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-item',
  templateUrl: './create-item.component.html',
  styleUrls: ['./create-item.component.css']
})
export class CreateItemComponent implements OnInit {

  item: Item = new Item();
  submitted = false;
  message = '';

  constructor(private itemService: ItemService,
    private router: Router) { }

  ngOnInit() {
  }

  newItem(): void {
    this.submitted = false;
    this.item = new Item();
  }

  save() {
    this.itemService.createItem(this.item)
      .subscribe(data => console.log(data), error => console.log(error));
    this.item = new Item();
    this.gotoList();
  }

  onSubmit() {
    this.message = '';
    if(parseFloat(this.item.valor) <= 0){
      this.submitted = false;
      this.message = 'Valor de ve ser maior que 0!';
     return;
      return;
    }

    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/items']);
  }
}
