package com.exercicio.altra.carrinhodecompras.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.exercicio.altra.carrinhodecompras.domain.Pedido;
import com.exercicio.altra.carrinhodecompras.domain.Usuario;


public interface PedidoRepository extends MongoRepository<Pedido, ObjectId> {
	

    List<Pedido> findByUsuario(Usuario usuario);
}
