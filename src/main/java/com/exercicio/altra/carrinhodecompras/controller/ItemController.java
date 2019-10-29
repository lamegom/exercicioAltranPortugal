package com.exercicio.altra.carrinhodecompras.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.altra.carrinhodecompras.domain.Item;
import com.exercicio.altra.carrinhodecompras.exception.ResourceNotFoundException;
import com.exercicio.altra.carrinhodecompras.services.ItemService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ItemController {
    @Autowired
    private ItemService itemservice;

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemservice.listAll();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "id") String itemId)
        throws ResourceNotFoundException {
        Item item = itemservice.getById(itemId);
        return ResponseEntity.ok().body(item);
    }
    
    @PostMapping("/items")
    public Item createEmployee(@Valid @RequestBody Item item) {
        return itemservice.saveOrUpdate(item);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem( @Valid @RequestBody Item item) throws ResourceNotFoundException {

        final Item updatedItem = itemservice.saveOrUpdate(item);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/items/{id}")
    public Map<String, Boolean> deleteItem(@PathVariable(value = "id") String itemId)
         throws ResourceNotFoundException {

        itemservice.delete(itemId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}