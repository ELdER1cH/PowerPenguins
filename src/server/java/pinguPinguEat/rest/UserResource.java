package pinguPinguEat.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pinguPinguEat.user.User;
import pinguPinguEat.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserResource {
    //initiert Reservation Service
    private final UserService userService;

    //Construktor
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    //Get a User, with userID as PathVariable and Password as RequestParam
    @GetMapping("/users/{userID}")
    public ResponseEntity<User> authenticate(@PathVariable UUID userID, @RequestParam(value = "password", defaultValue = "") String password) {
        User user = userService.authenticate(userID, password);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(user);
    }

    //PostMapping, creates new user
    @PostMapping("/user")
    public ResponseEntity<User> newUser(@RequestBody User user){
        if (userService.newUser(user) != null) {
            return ResponseEntity.ok(userService.newUser(user));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/users/{userID}")
    public ResponseEntity<HttpStatus> logoutUser(@PathVariable UUID userID) {
        if (userService.logoutUser(userID)) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }







}