package kh.aditya.first.user;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.*;

@Component
public class UserRestClient {

    private final RestClient restClient; //create an object of the RESTClient

    public UserRestClient(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://jsonplaceholder.typicode.com/").build();
        //https://jsonplaceholder.typicode.com/ is the parent URL
        //we will use https://jsonplaceholder.typicode.com/users
    }


    public List<User> findAll() {
        return restClient.get().uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    //we can directly get it from  https://jsonplaceholder.typicode.com/users/{id}
    public User findById(Integer id) {
        return restClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .body(User.class);
    }
}
