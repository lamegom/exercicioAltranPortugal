package com.exercicio.altra.carrinhodecompras.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.exercicio.altra.carrinhodecompras.domain.Item;


public interface ItemRepository extends CrudRepository<Item, ObjectId> {
}
