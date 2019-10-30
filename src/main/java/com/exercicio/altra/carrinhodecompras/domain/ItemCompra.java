package com.exercicio.altra.carrinhodecompras.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class ItemCompra {
	
	@Id
    private ObjectId _id;

	private Item item;
	
	private Long quantidade;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	
    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }
}
