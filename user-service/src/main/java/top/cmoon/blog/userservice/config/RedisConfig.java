package top.cmoon.blog.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RedisConfig {

    @Autowired
    Environment env;

//    @Bean
//    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
//        template.setConnectionFactory(factory);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new JdkSerializationRedisSerializer());
//        return template;
//    }


}