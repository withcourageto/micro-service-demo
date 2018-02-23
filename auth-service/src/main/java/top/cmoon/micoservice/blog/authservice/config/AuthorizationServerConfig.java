package top.cmoon.micoservice.blog.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Bean
    public RedisTokenStore tokenStore() {
        return new RedisTokenStore(connectionFactory);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();

    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        //@formatter:off
        clients.inMemory()
                .withClient("browser")
                .scopes("ui", "server")
                .secret("browser")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
            .and()
                .withClient("blog-service")
                .scopes("server")
                .secret("blog-service")
                .authorizedGrantTypes("client_credentials", "refresh_token")
            .and()
                .withClient("user-service")
                .scopes("server")
                .secret("user-service")
                .authorizedGrantTypes("client_credentials", "refresh_token")
            .and()
                .withClient("webapp")
                .scopes("server")
                .authorizedGrantTypes("implicit");

        //@formatter:on

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore());
    }
}
