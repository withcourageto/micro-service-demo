package top.cmoon.blog.userservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cmoon.blog.userservice.dao.UserRepository;
import top.cmoon.blog.userservice.model.User;
import top.cmoon.blog.userservice.service.UserService;

import java.util.Date;

@Service
class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getDetail(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User register(User user) {

        user.setIsDeleted(0);
        user.setIsDisabled(0);
        user.setCreateDate(new Date());

        return userRepository.save(user);
    }

    @Override
    public User getByNameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
