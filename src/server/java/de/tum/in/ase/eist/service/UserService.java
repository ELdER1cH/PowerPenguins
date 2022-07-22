package de.tum.in.ase.eist.service;

import org.springframework.stereotype.Service;
import pinguPinguEat.userElement.User;

import java.util.HashMap;
import java.util.UUID;

@Service
public class UserService {
    //Hashmap als Datenstruktur wohl am effizientesten
    private final HashMap<UUID, User> users;

    public UserService() {
        users = new HashMap<>();
    }


    public User authenticate(UUID Id, String password) {
        //TODO implement with Database access
        if(users.get(Id) != null) {
            if (users.get(Id).getPassword().equals(password)) {
                return users.get(Id);
            }
        }
        return null;
    }

    public User newUser(User user) {
        //TODO implement with Database access
        if (users.get(user.getUserID()) == null)  {
            users.put(user.getUserID(), user);
            return user;
        }
        return null;

    }

    public boolean logoutUser(UUID Id) {
        return users.get(Id) != null;
    }

}
