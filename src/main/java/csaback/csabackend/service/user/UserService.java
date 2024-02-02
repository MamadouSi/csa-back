package csaback.csabackend.service.user;

import csaback.csabackend.modele.User;

import java.util.List;

public interface UserService {

    List<User> lire();

    User findByLoginAndPassword(String login, String password);
}
