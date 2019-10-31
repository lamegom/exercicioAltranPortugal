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
  message = '';

  constructor(private usuarioService: UsuarioService,
    private router: Router ) { }

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
    

    this.message = '';

    this.usuarioService. getUsuarioByNome(this.usuario.nome).subscribe(data => {

      if(data == 0){

        if(!this.validateEmail(this.usuario.email)){
          this.submitted = false;
           this.message = 'Email invalido!';
          return;
        }

        this.submitted = true;
        this.save();

      } else {
        this.submitted = false;
        this.message = 'Usuario já existe!';
        return;
      }
    
    }, error => console.log(error));

        
  }

  validateEmail(email: string) : boolean {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

  gotoList() {
    this.router.navigate(['/usuarios']);
  }
}
