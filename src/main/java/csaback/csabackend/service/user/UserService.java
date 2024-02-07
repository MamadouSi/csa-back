package csaback.csabackend.service.user;

import csaback.csabackend.modele.User;

import java.util.List;

public interface UserService {

    User creer(User user);

    List<User> lire();

    User findByLoginAndPassword(String login, String password);
}
