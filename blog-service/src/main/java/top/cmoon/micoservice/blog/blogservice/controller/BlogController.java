package top.cmoon.micoservice.blog.blogservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.cmoon.micoservice.blog.blogservice.model.Blog;
import top.cmoon.micoservice.blog.blogservice.service.BlogService;

import java.security.Principal;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    @PreAuthorize("#oauth2.hasScope('ui')")
    public Blog add(@RequestBody Blog blog, Principal principal) {

        blog.setAuthorName(principal.getName());
        Blog savedBlog = blogService.add(blog);

        return savedBlog;
    }

    @GetMapping("/{id}")
    public Blog getDetail(@PathVariable int id) {
        return blogService.getDetail(id);
    }

}
