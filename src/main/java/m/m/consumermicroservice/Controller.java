package m.m.consumermicroservice;

import m.m.consumermicroservice.model.Role;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller {

    @GetMapping("/test")
    public String test(){
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<List<Role>> exchange = restTemplate.exchange("http://localhost:8081/roles/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Role>>() {
        });
        exchange.getBody();
        return exchange.getBody().toString();
    }

    @GetMapping("/zuul")
    public String callDbThroughZuul() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Role>> exchange = restTemplate.exchange("http://localhost:8080/db/roles", HttpMethod.GET, null, new ParameterizedTypeReference<List<Role>>() {
        });
        exchange.getBody();
        return exchange.getBody().toString();
    }
}
