package com.exercicio.altra.carrinhodecompras;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.exercicio.altra.carrinhodecompras.domain.ItemCompra;
import com.exercicio.altra.carrinhodecompras.domain.Pedido;
import com.exercicio.altra.carrinhodecompras.domain.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarrinhodecomprasApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PedidoControllerIntegrationTest {
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
     public void testGetAllPedidosByUserId() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/pedidos/1",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }


    @Test
    public void testCreatePedido() {
    	Pedido pedido = new Pedido();
    	pedido.setItems(new ArrayList<ItemCompra>());
        pedido.setUsuario(new Usuario());

        ResponseEntity<Pedido> postResponse = restTemplate.postForEntity(getRootUrl() + "/pedido", pedido, Pedido.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }




}
