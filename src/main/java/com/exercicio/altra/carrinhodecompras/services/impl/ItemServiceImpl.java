package com.exercicio.altra.carrinhodecompras.services.impl;



	import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.altra.carrinhodecompras.domain.Item;
import com.exercicio.altra.carrinhodecompras.repositories.ItemRepository;
import com.exercicio.altra.carrinhodecompras.services.ItemService;
import com.mongodb.util.JSON;


	@Service
	public class ItemServiceImpl implements ItemService {

		@Autowired
		private ItemRepository itemRepository;



	    @Override
	    public List<Item> listAll() {
	        List<Item> items = new ArrayList<>();
	        itemRepository.findAll().forEach(items::add);
	        return items;
	    }

	    @Override
	    public Item getById(String id) {
	    	
	    	ObjectId dbId = null;
	    	try {
	    	     JSONObject jsonObject = new JSONObject(id);
	    	     dbId = new ObjectId(jsonObject.getInt("timestamp"), jsonObject.getInt("machineIdentifier"), (short) jsonObject.getLong("processIdentifier"), jsonObject.getInt("counter"));
	    	}catch (Exception err){
	    	     err.printStackTrace();
	    	}
	    	
	    	
	        return itemRepository.findById(dbId).orElse(null);
	    }

	    @Override
	    public Item saveOrUpdate(Item product) {
	    	itemRepository.save(product);
	        return product;
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
	    	
	    	itemRepository.deleteById(dbId);
	    }

	   
	}
