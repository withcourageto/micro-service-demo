package top.cmoon.micoservice.blog.blogservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import top.cmoon.micoservice.common.security.CustomUserInfoTokenServices;

import javax.servlet.http.HttpServletResponse;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http
            .csrf().disable()
            .exceptionHandling()
                .authenticationEntryPoint((req, resp, ex) -> resp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
            .and()
                .authorizeRequests()
                .anyRequest().authenticated()
            .and()
                .httpBasic();
        //@formatter:on
    }

    @Autowired
    private ResourceServerProperties sso;

    // custom ResourceServerTokenServices , make @Pre#oauth.hasScope() work
    @Bean
    public ResourceServerTokenServices tokenServices() {
        return new CustomUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
    }


}
