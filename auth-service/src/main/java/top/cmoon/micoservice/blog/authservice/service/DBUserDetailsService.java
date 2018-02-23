package top.cmoon.micoservice.blog.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.cmoon.micoservice.blog.authservice.domain.SysUser;
import top.cmoon.micoservice.blog.authservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DBUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<SysUser> realUser = userRepository.findOneByUsername(username);

        return realUser
                .map(u -> new User(u.getUsername(), u.getPassword(), new ArrayList<>()))
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
