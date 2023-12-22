package com.auth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;

import java.time.Duration;
import java.util.UUID;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class configAuthorization3 {
    private final UserDetailsService userDetailsService;

    @Autowired
    public configAuthorization3(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //TODO use this bean when using database with OAUTH 2
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider()
    {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }



    /*
    * create user in memory for access to endpoint that we allow
    * */
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        InMemoryUserDetailsManager user = new InMemoryUserDetailsManager();
//        user.createUser(User.withUsername("admin")
//                .password(passwordEncoder().encode("172212"))
////                        .password("172212")
//                .roles("ADMIN")
//                .build()
//        );
//        user.createUser(User.withUsername("user")
//                        .roles("USER")
//                        .passwordEncoder(s -> passwordEncoder().encode("172212"))
////                        .password("172212")
//                .build()
//        );
//        return user;
//    }

    //default endpoint example http://exmaple:8080/oauth2/authorize we come custom it by using this
    //    TODO: Customizing the configuration
    //     this bean need to do ((ទាមទារ)Require)
    /*
     * authorizationServerConfigurer .authorizationServerSettings(authorizationServerSettings)
     * authorizationServerSettings(): The AuthorizationServerSettings (REQUIRED)
     * for customizing configuration settings for the OAuth2 authorization server.
     * */
    @Bean
    public AuthorizationServerSettings authorizationServerSettings() {
        return AuthorizationServerSettings.builder().build();
    }


    /*
     *
     *config with OAUTH2
     * */
    @Bean
    @Order(1)
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(httpSecurity);
        httpSecurity.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
                //TODO like when u using in form SCOPE = OPENID(Defaults)
                .oidc(Customizer.withDefaults());
        // TODO like if u access to endpoint u want but u not yet login so it will redirect u to defaults loginFormUrl
        httpSecurity.exceptionHandling(
                c -> c.defaultAuthenticationEntryPointFor(
                        new LoginUrlAuthenticationEntryPoint("/login"),
                        new MediaTypeRequestMatcher(MediaType.TEXT_HTML)
                )
        );
        return httpSecurity.build();
    }


    /*
    * create for web MVC
    * */
    @Bean
    @Order(2)
    public SecurityFilterChain webSecurity(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers("/public").permitAll()
                .requestMatchers(HttpMethod.GET,"/public1").hasAnyAuthority("ROLE_read","ROLE_write")
                .anyRequest().authenticated()
        );
        httpSecurity.formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }


    // ===================================== <IN MEMORY> ===================================== //
    @Bean
    public RegisteredClientRepository registeredClientRepository() {

        var registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("client")
                .clientSecret(passwordEncoder().encode("172212")) // store in secret manager
                .scopes(scopes -> {
                    scopes.add("openid");
//                    scopes.add("profile");
//                    scopes.add("email");
//                    scopes.add("phone");
//                    scopes.add("address");
                    //scopes.add("keys.write");
                })
                .redirectUri("http://127.0.0.1:8083/login/oauth2/code/kangchi")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.NONE) // public client - PKCE
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                // grant_type:client_credentials, client_id & client_secret, redirect_uri
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)
                .authorizationGrantTypes(
                        grantType -> {
                            grantType.add(AuthorizationGrantType.AUTHORIZATION_CODE);
                            grantType.add(AuthorizationGrantType.REFRESH_TOKEN);
                            grantType.add(AuthorizationGrantType.CLIENT_CREDENTIALS);
                            //grantType.add(new AuthorizationGrantType("custom_password"));
                        }
                )
                .tokenSettings(tokenSettings())
                .clientSettings(clientSettings())
                .build();

        return new InMemoryRegisteredClientRepository(registeredClient);
    }

    //TODO create time for token exp
    public TokenSettings tokenSettings() {
        return TokenSettings.builder()
                .accessTokenFormat(OAuth2TokenFormat.SELF_CONTAINED)
                .accessTokenTimeToLive(Duration.ofDays(1))
                .reuseRefreshTokens(true)
                .refreshTokenTimeToLive(Duration.ofDays(7))
                .build();
    }

    public ClientSettings clientSettings() {
        return ClientSettings.builder()
                .requireAuthorizationConsent(true)
                .requireProofKey(true)
                .build();
    }


}
