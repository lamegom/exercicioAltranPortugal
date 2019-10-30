import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ItemDetailsComponent } from './item-details/item-details.component';
import { CreateItemComponent } from './create-item/create-item.component';
import { ItemListComponent } from './item-list/item-list.component';
import { UpdateItemComponent } from './update-item/update-item.component';
import { UsuarioDetailsComponent } from './usuario-details/usuario-details.component';
import { CreateUsuarioComponent } from './create-usuario/create-usuario.component';
import { UsuarioListComponent } from './usuario-list/usuario-list.component';
import { UpdateUsuarioComponent } from './update-usuario/update-usuario.component';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { CarrinhoUsuarioComponent } from './carrinho-usuario/carrinho-usuario.component';
import { CarrinhoListComponent } from './carrinho-list/carrinho-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'items', pathMatch: 'full' },
  { path: 'items', component: ItemListComponent },
  { path: 'add', component: CreateItemComponent },
  { path: 'update/:id', component: UpdateItemComponent },
  { path: 'details/:id', component: ItemDetailsComponent },
  { path: 'usuarios', component: UsuarioListComponent },
  { path: 'addUsuario', component: CreateUsuarioComponent },
  { path: 'updateUsuario/:id', component: UpdateUsuarioComponent },
  { path: 'detailsUsuario/:id', component: UsuarioDetailsComponent },

  { path: 'carrinho/:id', component: CarrinhoComponent },
  { path: 'carrinho', component: CarrinhoComponent },
  { path: 'carrinho-usuario', component: CarrinhoUsuarioComponent },
  { path: 'pedidos/:id', component: CarrinhoListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }