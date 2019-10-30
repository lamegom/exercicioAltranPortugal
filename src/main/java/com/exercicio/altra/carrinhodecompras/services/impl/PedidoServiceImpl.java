package com.exercicio.altra.carrinhodecompras.services.impl;



	import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.altra.carrinhodecompras.domain.Pedido;
import com.exercicio.altra.carrinhodecompras.domain.Usuario;
import com.exercicio.altra.carrinhodecompras.repositories.PedidoRepository;
import com.exercicio.altra.carrinhodecompras.repositories.UsuarioRepository;
import com.exercicio.altra.carrinhodecompras.services.PedidoService;


	@Service
	public class PedidoServiceImpl implements PedidoService {

		@Autowired
		private PedidoRepository pedidoRepository;

		@Autowired
		private UsuarioRepository usuarioRepository;

	    @Override
	    public List<Pedido> listAll(String id) {
	        	    	
	    	ObjectId dbId = null;
	    	try {
	    	     JSONObject jsonObject = new JSONObject(id);
	    	     dbId = new ObjectId(jsonObject.getInt("timestamp"), jsonObject.getInt("machineIdentifier"), (short) jsonObject.getLong("processIdentifier"), jsonObject.getInt("counter"));
	    	}catch (Exception err){
	    	     err.printStackTrace();
	    	}
	        Usuario usuario = usuarioRepository.findById(dbId).orElse(null);
	        
	        List<Pedido> pedidos = new ArrayList<>();
	        pedidoRepository.findAll().forEach(pedidos::add);
	        
	        return pedidos;
	    }

	    @Override
	    public Pedido saveOrUpdate(Pedido pedido) {
	    	pedidoRepository.save(pedido);
	        return pedido;
	    }
	    

	    

	   

	   
	}
