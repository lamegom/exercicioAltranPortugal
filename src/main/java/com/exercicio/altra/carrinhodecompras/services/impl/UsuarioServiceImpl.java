package com.exercicio.altra.carrinhodecompras.services.impl;



	import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.altra.carrinhodecompras.domain.Item;
import com.exercicio.altra.carrinhodecompras.domain.Usuario;
import com.exercicio.altra.carrinhodecompras.repositories.UsuarioRepository;
import com.exercicio.altra.carrinhodecompras.services.UsuarioService;


	@Service
	public class UsuarioServiceImpl implements UsuarioService {

		@Autowired
		private UsuarioRepository usuarioRepository;



	    @Override
	    public List<Usuario> listAll() {
	        List<Usuario> usuarios = new ArrayList<>();
	        usuarioRepository.findAll().forEach(usuarios::add);
	        return usuarios;
	    }

	    @Override
	    public Usuario getById(String id) {
	    	
	    	ObjectId dbId = null;
	    	try {
	    	     JSONObject jsonObject = new JSONObject(id);
	    	     dbId = new ObjectId(jsonObject.getInt("timestamp"), jsonObject.getInt("machineIdentifier"), (short) jsonObject.getLong("processIdentifier"), jsonObject.getInt("counter"));
	    	}catch (Exception err){
	    	     err.printStackTrace();
	    	}
	        return usuarioRepository.findById(dbId).orElse(null);
	    }

	    @Override
	    public Usuario saveOrUpdate(Usuario usuario) {
	    	usuarioRepository.save(usuario);
	        return usuario;
	    }

	    @Override
	    public void delete(String id) {
	    	
	    	ObjectId dbId = null;
	    	try {
	    	     JSONObject jsonObject = new JSONObject(id);
	    	     dbId = new ObjectId(jsonObject.getInt("timestamp"), jsonObject.getInt("machineIdentifier"), (short) jsonObject.getLong("processIdentifier"), jsonObject.getInt("counter"));
	    	}catch (Exception err){
	    	     err.printStackTrace();
	    	}
	    	
	    	usuarioRepository.deleteById(dbId);
	    }

	    @Override
	    public int getByName(String nome) {
	    	
	    	return usuarioRepository.findByNome(nome).size();
	    }
	   
	}
