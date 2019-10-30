package com.exercicio.altra.carrinhodecompras.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.altra.carrinhodecompras.domain.ItemCompra;
import com.exercicio.altra.carrinhodecompras.domain.Pedido;
import com.exercicio.altra.carrinhodecompras.services.PedidoService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedidos/{id}")
    public List<Pedido> getAllPedidos(@PathVariable(value = "id") String usuarioId ) {
        return pedidoService.listAll(usuarioId);
    }

    
    @PostMapping("/pedidos")
    public Pedido createPedido(@Valid @RequestBody Pedido pedido) {
        return pedidoService.saveOrUpdate(pedido);
    }



}