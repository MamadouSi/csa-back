package csaback.csabackend.repository;

import csaback.csabackend.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User , Long >{
    User findByLogin(String login);
}
