package top.cmoon.micoservice.blog.blogservice.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import top.cmoon.micoservice.blog.blogservice.model.Blog;

@Getter
public class BlogAddedEvent extends ApplicationEvent {

    private Blog blog;

    public BlogAddedEvent(Object source, Blog blog) {
        super(source);
        this.blog = blog;
    }
}
