package top.cmoon.blog.userservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import top.cmoon.blog.userservice.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

}
