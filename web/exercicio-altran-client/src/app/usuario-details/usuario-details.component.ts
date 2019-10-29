import { Usuario } from '../usuario';
import { Component, OnInit, Input } from '@angular/core';
import { UsuarioService } from '../usuario.service';
import { UsuarioListComponent } from '../usuario-list/usuario-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-usuario-details',
  templateUrl: './usuario-details.component.html',
  styleUrls: ['./usuario-details.component.css']
})
export class UsuarioDetailsComponent implements OnInit {

  id: string;
  usuario: Usuario;

  constructor(private route: ActivatedRoute,private router: Router,
    private usuarioService: UsuarioService) { }

  ngOnInit() {
    this.usuario = new Usuario();

    this.id = this.route.snapshot.params['id'];
    
    this.usuarioService.getUsuario(this.id)
      .subscribe(data => {
        console.log(data)
        this.usuario = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['usuarios']);
  }

  update(id: string){
    this.router.navigate(['updateUsuario', JSON.stringify(id)]);
  }
}