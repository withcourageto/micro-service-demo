package top.cmoon.blog.userservice.service;


import top.cmoon.blog.userservice.model.User;

public interface UserService {

    User getDetail(Integer id);

    User register(User user);

    User getByNameAndPassword(String username, String password);

    User getByUsername(String username);

}
