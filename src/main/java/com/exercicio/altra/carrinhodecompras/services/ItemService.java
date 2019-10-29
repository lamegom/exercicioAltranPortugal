package com.exercicio.altra.carrinhodecompras.services;


	import java.util.List;

import com.exercicio.altra.carrinhodecompras.domain.Item;
import com.exercicio.altra.carrinhodecompras.domain.Usuario;


	public interface ItemService {

	    List<Item> listAll();

	    Item getById(String id);

	    Item saveOrUpdate(Item item);

	    void delete(String id);


	}
