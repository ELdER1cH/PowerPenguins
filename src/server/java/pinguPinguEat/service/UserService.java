package pinguPinguEat.service;

import org.springframework.stereotype.Service;
import pinguPinguEat.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final List<User> users;

    public UserService() {
        users = new ArrayList<>();
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
