package top.cmoon.micoservice.blog.blogservice.client;

import top.cmoon.micoservice.blog.blogservice.domain.User;

public interface UserServiceClient {

    User getDetail(Integer id);

    User getDetail(String username);
}
