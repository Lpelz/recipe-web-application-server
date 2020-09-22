package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import server.domain.User;
import server.service.UserService;

@CrossOrigin
@RestController
public class UserController { 

    @Autowired
    private UserService userService;
    
    @PostMapping(value = "/user", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public boolean register(@RequestBody User user){
        return userService.register(user);
    }
    
    @PostMapping(value = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public boolean login(@RequestBody User user){
        return userService.login(user);
    }
}