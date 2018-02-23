package top.cmoon.micoservice.blog.authservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.cmoon.micoservice.blog.authservice.dto.User;

@FeignClient("user-service")
public interface UserServiceClient {

    @GetMapping("/user/users/info/{name}")
    User getUserByName(@PathVariable("name") String name);

}
