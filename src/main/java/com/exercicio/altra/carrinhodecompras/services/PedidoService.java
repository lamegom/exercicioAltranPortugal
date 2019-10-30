package com.exercicio.altra.carrinhodecompras.services;


	import java.util.List;

import com.exercicio.altra.carrinhodecompras.domain.ItemCompra;
import com.exercicio.altra.carrinhodecompras.domain.Pedido;


	public interface PedidoService {

	    List<Pedido> listAll(String id);

	    Pedido saveOrUpdate(Pedido pedido);



	}
