package com.exercicio.altra.carrinhodecompras.domain;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Pedido {
    @Id
    private ObjectId _id;

    private Usuario usuario;

    private List<ItemCompra> items;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ItemCompra> getItems() {
		return items;
	}

	public void setItems(List<ItemCompra> items) {
		this.items = items;
	}

    


}
