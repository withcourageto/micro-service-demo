package top.cmoon.micoservice.blog.blogservice.service;

import top.cmoon.micoservice.blog.blogservice.model.Blog;

import java.util.List;

public interface BlogService {


    Blog add(Blog blog);

    Blog getDetail(int id);

    List<Blog> page(int pageNo, int pageSize);

    List<Blog> usersBlog(int pageNo, int pageSize, int userId);

}
