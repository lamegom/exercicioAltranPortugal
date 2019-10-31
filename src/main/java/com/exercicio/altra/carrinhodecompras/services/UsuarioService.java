package com.exercicio.altra.carrinhodecompras.services;


	import java.util.List;

import com.exercicio.altra.carrinhodecompras.domain.Item;
import com.exercicio.altra.carrinhodecompras.domain.Usuario;


	public interface UsuarioService {

	    List<Usuario> listAll();

	    Usuario getById(String id);

	    Usuario saveOrUpdate(Usuario usuario);

	    void delete(String id);

		int getByName(String nome);


	}
