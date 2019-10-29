package com.exercicio.altra.carrinhodecompras;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.exercicio.altra.carrinhodecompras.domain.Item;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarrinhodecomprasApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {
     @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void contextLoads() {

     }

     @Test
     public void testGetAllItems() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/items",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetItemById() {
        Item item = restTemplate.getForObject(getRootUrl() + "/item/1", Item.class);
        System.out.println(item.getNome());
        assertNotNull(item);
    }

    @Test
    public void testCreateItem() {
    	Item item = new Item();
    	item.setNome("carro");
    	item.setValor(new BigDecimal("1000.00"));

        ResponseEntity<Item> postResponse = restTemplate.postForEntity(getRootUrl() + "/item", item, Item.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateItem() {
        int id = 1;
        Item item = restTemplate.getForObject(getRootUrl() + "/item/" + id, Item.class);
        item.setNome("moto");
        item.setValor(new BigDecimal("500.00"));
        restTemplate.put(getRootUrl() + "/item/" + id, item);
        Item updatedEmployee = restTemplate.getForObject(getRootUrl() + "/item/" + id, Item.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void testDeleteItem() {
         int id = 2;
         Item item = restTemplate.getForObject(getRootUrl() + "/item/" + id, Item.class);
         assertNotNull(item);
         restTemplate.delete(getRootUrl() + "/item/" + id);
         try {
        	 item = restTemplate.getForObject(getRootUrl() + "/item/" + id, Item.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}
