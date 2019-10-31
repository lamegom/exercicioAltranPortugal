package com.exercicio.altra.carrinhodecompras.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.altra.carrinhodecompras.domain.Usuario;
import com.exercicio.altra.carrinhodecompras.exception.ResourceNotFoundException;
import com.exercicio.altra.carrinhodecompras.services.UsuarioService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioservice;

    @GetMapping("/usuarios")
    public List<Usuario> getAllusuarios() {
        return usuarioservice.listAll();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getusuarioById(@PathVariable(value = "id") String usuarioId)
        throws ResourceNotFoundException {
    	Usuario usuario = usuarioservice.getById(usuarioId);
        return ResponseEntity.ok().body(usuario);
    }
    
    @GetMapping("/usuarios/nome/{nome}")
    public ResponseEntity<Integer> getusuarioByNome(@PathVariable(value = "nome") String nome)
        throws ResourceNotFoundException {
    	int result = usuarioservice.getByName(nome);
        return ResponseEntity.ok().body(result);
    }
    
    @PostMapping("/usuarios")
    public Usuario createEmployee(@Valid @RequestBody Usuario usuario) {
        return usuarioservice.saveOrUpdate(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> updateusuario( @Valid @RequestBody Usuario usuario) throws ResourceNotFoundException {

        final Usuario updatedusuario = usuarioservice.saveOrUpdate(usuario);
        return ResponseEntity.ok(updatedusuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public Map<String, Boolean> deleteusuario(@PathVariable(value = "id") String usuarioId)
         throws ResourceNotFoundException {

        usuarioservice.delete(usuarioId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}