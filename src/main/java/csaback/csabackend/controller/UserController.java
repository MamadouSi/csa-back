package csaback.csabackend.controller;


import csaback.csabackend.modele.User;
import csaback.csabackend.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

   @GetMapping("/read")
    public List<User> read (){return userService.lire();};

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User credentials) {
        User authenticatedUser = userService.findByLoginAndPassword(credentials.getLogin(), credentials.getPassword());

        if (authenticatedUser != null) {

            return new ResponseEntity<>("Authentification réussie", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentification échouée", HttpStatus.UNAUTHORIZED);
        }
    };


}
