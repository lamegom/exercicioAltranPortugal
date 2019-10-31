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

import com.exercicio.altra.carrinhodecompras.domain.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarrinhodecomprasApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsuarioControllerIntegrationTest {
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
     public void testGetAllUsuarios() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/usuarios",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetUsuarioById() {
        Usuario usuario = restTemplate.getForObject(getRootUrl() + "/usuario/1", Usuario.class);
        System.out.println(usuario.getNome());
        assertNotNull(usuario);
    }

    @Test
    public void testCreateUsuario() {
    	Usuario usuario = new Usuario();
    	usuario.setNome("Marcio");
        usuario.setEmail("lamegom@me.com");

        ResponseEntity<Usuario> postResponse = restTemplate.postForEntity(getRootUrl() + "/usuario", usuario, Usuario.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateUsuario() {
        int id = 1;
        Usuario usuario = restTemplate.getForObject(getRootUrl() + "/usuario/" + id, Usuario.class);
        usuario.setNome("Marcio");
        usuario.setEmail("lamegom@me.com");
        restTemplate.put(getRootUrl() + "/usuario/" + id, usuario);
        Usuario updatedEmployee = restTemplate.getForObject(getRootUrl() + "/usuario/" + id, Usuario.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void testDeleteUsuario() {
         int id = 2;
         Usuario usuario = restTemplate.getForObject(getRootUrl() + "/usuario/" + id, Usuario.class);
         assertNotNull(usuario);
         restTemplate.delete(getRootUrl() + "/usuario/" + id);
         try {
        	 usuario = restTemplate.getForObject(getRootUrl() + "/usuario/" + id, Usuario.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}
