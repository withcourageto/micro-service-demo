package top.cmoon.micoservice.blog.blogservice.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import top.cmoon.micoservice.blog.blogservice.event.BlogAddedEvent;
import top.cmoon.micoservice.blog.blogservice.msg.MsgSender;

@Component
@Slf4j
public class BlogAddedSenderListener implements ApplicationListener<BlogAddedEvent> {


    @Autowired
    private MsgSender msgSender;

    @Override
    @Async
    public void onApplicationEvent(BlogAddedEvent blogAddedEvent) {

        log.info("-------------------------------");
        log.info("send blog added event");
        log.info("-------------------------------");
        msgSender.sendMsg(blogAddedEvent.getBlog());
    }

}
