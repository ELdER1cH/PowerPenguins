package pinguPinguEat.service;

import org.springframework.stereotype.Service;
import pinguPinguEat.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    //Hashmap als Datenstruktur wohl am effizientesten
    private final HashMap<UUID, User> users;

    public UserService() {
        users = new HashMap<>();
    }


    public User authenticate(UUID Id, String password) {
        //TODO implement
        return null;
    }

    public User newUser(User user) {
        //TODO implement
        return null;
    }

}
