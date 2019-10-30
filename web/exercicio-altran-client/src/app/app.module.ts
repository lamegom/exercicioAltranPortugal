import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app.routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { CreateItemComponent } from './create-item/create-item.component';
import { ItemDetailsComponent } from './item-details/item-details.component';
import { ItemListComponent } from './item-list/item-list.component';
import { UpdateItemComponent } from './update-item/update-item.component';
import { CreateUsuarioComponent } from './create-usuario/create-usuario.component';
import { UsuarioDetailsComponent } from './usuario-details/usuario-details.component';
import { UsuarioListComponent } from './usuario-list/usuario-list.component';
import { UpdateUsuarioComponent } from './update-usuario/update-usuario.component';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { CarrinhoUsuarioComponent } from './carrinho-usuario/carrinho-usuario.component';
import { CarrinhoListComponent } from './carrinho-list/carrinho-list.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateItemComponent,
    ItemDetailsComponent,
    ItemListComponent,
    UpdateItemComponent,
    CreateUsuarioComponent,
    UsuarioDetailsComponent,
    UsuarioListComponent,
    UpdateUsuarioComponent,
    CarrinhoComponent,
    CarrinhoUsuarioComponent,
    CarrinhoListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }