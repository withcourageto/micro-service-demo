package top.cmoon.micoservice.blog.authservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import top.cmoon.micoservice.blog.authservice.domain.SysUser;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<SysUser, Integer> {

    Optional<SysUser> findOneByUsername(String username);
}
