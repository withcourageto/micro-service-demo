package top.cmoon.blog.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.cmoon.blog.userservice.model.User;
import top.cmoon.blog.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getDetail(@PathVariable Integer id) {
        return userService.getDetail(id);
    }

    @GetMapping
    public User getByNameAndPassword(@RequestBody User user) {
        return userService.getByNameAndPassword(user.getUsername(), user.getPassword());
    }

    @GetMapping("/info/{username}")
    public User getByName(@PathVariable("username") String name) {
        return userService.getByUsername(name);
    }


    @PostMapping
    public User register(@RequestBody User user) {

        return userService.register(user);
    }

}
