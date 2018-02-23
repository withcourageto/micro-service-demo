package top.cmoon.micoservice.blog.authservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/users/current")
    public Principal user(Principal user) {
        return user;
    }

}
