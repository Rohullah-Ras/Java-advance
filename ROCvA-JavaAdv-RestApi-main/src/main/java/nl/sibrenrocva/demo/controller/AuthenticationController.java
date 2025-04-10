package nl.sibrenrocva.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import nl.sibrenrocva.demo.model.User;
import nl.sibrenrocva.demo.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")

    public boolean AuthenticateUser(User user) {
        return authenticationService.authenticateUser(user);
    }

    // public Boolean AuthenticateUser(@RequestBody User user) {

    // }
}