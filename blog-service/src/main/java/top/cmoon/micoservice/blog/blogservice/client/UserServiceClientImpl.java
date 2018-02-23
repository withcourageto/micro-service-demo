package top.cmoon.micoservice.blog.blogservice.client;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;
import top.cmoon.micoservice.blog.blogservice.domain.User;

@Component
@Primary
public class UserServiceClientImpl implements UserServiceClient {

    private static Logger logger = LoggerFactory.getLogger(UserServiceClientImpl.class);

    @Autowired
    private OAuth2RestOperations userInfoRestTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getDetailError", ignoreExceptions = OAuth2Exception.class)
    public User getDetail(Integer id) {

        logger.info("use rest template invoke user client");
        return userInfoRestTemplate.getForEntity("http://USER-SERVICE/user/users/" + id, User.class).getBody();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getDetailError", ignoreExceptions = OAuth2Exception.class)
    public User getDetail(String username) {
        return userInfoRestTemplate.getForEntity("http://USER-SERVICE/user/users/info/" + username, User.class).getBody();
    }

    @SuppressWarnings("unused")
    public User getDetailError(String username) {
        return fallbackUser();
    }

    @SuppressWarnings("unused")
    public User getDetailError(Integer id) {
        return fallbackUser();
    }

    private User fallbackUser() {
        logger.warn(" UserServiceClientImpl.getDetail use fallback method ");

        User user = new User();
        user.setId(-1);
        return user;
    }


}
