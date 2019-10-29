import { UsuarioService } from '../usuario.service';
import { Usuario } from '../usuario';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-usuario',
  templateUrl: './create-usuario.component.html',
  styleUrls: ['./create-usuario.component.css']
})
export class CreateUsuarioComponent implements OnInit {

  usuario: Usuario = new Usuario();
  submitted = false;

  constructor(private usuarioService: UsuarioService,
    private router: Router) { }

  ngOnInit() {
  }

  newUsuario(): void {
    this.submitted = false;
    this.usuario = new Usuario();
  }

  save() {
    this.usuarioService.createUsuario(this.usuario)
      .subscribe(data => console.log(data), error => console.log(error));
    this.usuario = new Usuario();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/usuarios']);
  }
}
