package csaback.csabackend.service.user;

import csaback.csabackend.modele.User;
import csaback.csabackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private  final UserRepository userRepository;

    private JdbcTemplate jdbcTemplate;

    @Override
    public User creer(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> lire() {
        return userRepository.findAll();
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        String sql = "SELECT * FROM users WHERE login = ? AND password = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));

            // Vérification du mot de passe sans hachage (stocké en clair dans la base de données)
            String storedPassword = rs.getString("password");
            if (password.equals(storedPassword)) {
                user.setPassword(storedPassword);
                user.setRole(rs.getString("role"));
                return user;
            } else {
                // Mot de passe incorrect
                return null;
            }
        }, login, password);
    }
}



