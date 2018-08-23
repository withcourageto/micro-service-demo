package top.cmoon.micoservice.blog.blogservice.msg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import top.cmoon.micoservice.blog.blogservice.model.Blog;

@Component
public class MsgSender {


    @Autowired
    @Qualifier("output")
    MessageChannel output;


    public void sendMsg(Blog blog) {
        output.send(MessageBuilder.withPayload(blog).build());
    }

}
