package top.cmoon.micoservice.blog.authservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private Integer id;
    private String username;
    private String password;

}
