package com.exercicio.altra.carrinhodecompras.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.exercicio.altra.carrinhodecompras.domain.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, ObjectId> {
	
	public List<Usuario> findByNome(String nome);
}
