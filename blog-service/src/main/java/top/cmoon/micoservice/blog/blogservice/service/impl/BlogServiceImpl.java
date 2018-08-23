package top.cmoon.micoservice.blog.blogservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import top.cmoon.micoservice.blog.blogservice.client.UserServiceClient;
import top.cmoon.micoservice.blog.blogservice.dao.BlogRepository;
import top.cmoon.micoservice.blog.blogservice.domain.User;
import top.cmoon.micoservice.blog.blogservice.event.BlogAddedEvent;
import top.cmoon.micoservice.blog.blogservice.model.Blog;
import top.cmoon.micoservice.blog.blogservice.msg.MsgSender;
import top.cmoon.micoservice.blog.blogservice.service.BlogService;
import top.cmoon.micoservice.blog.blogservice.util.DateUtil;

import static top.cmoon.micoservice.blog.blogservice.constant.Constant.Bool.FALSE;

import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private MsgSender msgSender;


    @Autowired
    private ApplicationContext context;


    @Override
    public Blog add(Blog blog) {

        // user info
        User user = userServiceClient.getDetail(blog.getAuthorName());

        if (user.getId() == -1) {
            throw new RuntimeException("user service is not available");
        }


        blog.setAuthorName(user.getUsername());

        // init info
        blog.setLikeCount(0);
        blog.setVisitCount(0L);

        blog.setCreateDate(DateUtil.now());
        blog.setIsDeleted(FALSE);
        blog.setIsDisabled(FALSE);

        // persistence
        blogRepository.save(blog);

        // 博客添加事件
        BlogAddedEvent blogAddedEvent = new BlogAddedEvent(this, blog);

        context.publishEvent(blogAddedEvent);

        return blog;
    }

    @Override
    public Blog getDetail(int id) {

        return blogRepository.findOne(id);
    }

    @Override
    public List<Blog> page(int pageNo, int pageSize) {

        return null;
    }

    @Override
    public List<Blog> usersBlog(int pageNo, int pageSize, int userId) {
        return null;
    }
}
