package pinguPinguEat.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import pinguPinguEat.user.User;

import java.util.HashMap;

public class UserController {
    private final WebClient webClient;
    private final HashMap<User, Boolean> usersCollection;

    public UserController() {
        this.usersCollection = new HashMap<>();
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080/")
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public void addUser(User user) {
        webClient.post()
                .uri("/users")
                .bodyValue(user)
                .retrieve()
                .bodyToMono(User.class)
                .onErrorStop()
                .subscribe(newPerson -> usersCollection.put(newPerson, false));
    }

    public void authenticate(String password, User user) {
        webClient.put()
                .uri(uriBuilder -> uriBuilder
                        .path("/users/" + user.getUserID())
                        .queryParam("password", password)
                        .build())
                .retrieve()
                .bodyToMono(User.class)
                .onErrorStop()
                .subscribe(newUser -> usersCollection.replace(newUser, true));
    }

    public void logoutUser(User currentUser) {
        webClient.delete()
                .uri("/users/" + currentUser.getUserID())
                .retrieve()
                .toBodilessEntity()
                .onErrorStop()
                .subscribe(User -> usersCollection.replace(currentUser, false));
    }



}
