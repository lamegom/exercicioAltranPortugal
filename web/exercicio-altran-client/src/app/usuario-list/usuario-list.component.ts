import { UsuarioDetailsComponent } from '../usuario-details/usuario-details.component';
import { Observable } from "rxjs";
import { UsuarioService } from "../usuario.service";
import { Usuario } from "../usuario";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-usuario-list",
  templateUrl: "./usuario-list.component.html",
  styleUrls: ["./usuario-list.component.css"]
})
export class UsuarioListComponent implements OnInit {
  usuarios: Observable<Usuario[]>;

  constructor(private usuarioService: UsuarioService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.usuarios = this.usuarioService.getUsuariosList();
  }

  deleteUsuario(id: string) {
    this.usuarioService.deleteUsuario(JSON.stringify(id))
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  usuarioDetails(id: string){
    this.router.navigate(['detailsUsuario', JSON.stringify(id)]);
  }

  carrinho(id: string){
    this.router.navigate(['pedidos', JSON.stringify(id)]);
  }
}
