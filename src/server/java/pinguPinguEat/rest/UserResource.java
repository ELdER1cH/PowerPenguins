package pinguPinguEat.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pinguPinguEat.ReservationModel.Reservation;
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
    @GetMapping("/user/{userID}")
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
        return ResponseEntity.ok(userService.newUser(user));
    }







}