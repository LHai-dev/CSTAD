package com.example.spring4mbankingapisasu.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    //Define in-memory user

    private final CustomerAuthentionEntryPoint customerAuthentionEntryPoint;
    private final UserDetailsServiceImp userDetailsServiceImp;
    private final PasswordEncoder encoder;
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        InMemoryUserDetailsManager userDetailsManager=new InMemoryUserDetailsManager();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}0809")
//                .roles("ADMIN")
//                .build();
//        UserDetails goldUser = User.builder()
//                .username("goldUser")
//                .password("{noop}0809")
//                .roles("ACCOUNT")
//                .build();
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{noop}0809")
//                .roles("USER")
//                .build();
//        userDetailsManager.createUser(admin);
//        userDetailsManager.createUser(goldUser);
//        userDetailsManager.createUser(user);
//        return userDetailsManager;
//    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsServiceImp);
        auth.setPasswordEncoder(encoder);
        return auth;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("it work fliterChain");

        http.csrf(token->token.disable());

        //Security mechanism
//        http.httpBasic();
//            http.oauth2Client();

        //Authorize URL mapping
      //  http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/api/v1/auth/**").permitAll();


            // only admin can access that api
//            auth.requestMatchers(HttpMethod.GET,"/api/v1/users/**").hasAnyAuthority("SCOPE_READ","SCOPE_FULL_CONTROL");
//            auth.requestMatchers(HttpMethod.PUT,"/api/v1/users/**").hasAnyAuthority("SCOPE_UPDATE","SCOPE_FULL_CONTROL");
//            auth.requestMatchers(HttpMethod.POST,"/api/v1/users/**").hasAnyAuthority("SCOPE_WRITE","SCOPE_FULL_CONTROL");
//            auth.requestMatchers(HttpMethod.DELETE,"/api/v1/users/**").hasAnyAuthority("SCOPE_DELETE","SCOPE_FULL_CONTROL");
//            auth.requestMatchers(HttpMethod.POST,"/api/v1/users/**").hasRole("SYSTEM");
            auth.requestMatchers(HttpMethod.GET , "/api/v1/users/**").hasAnyAuthority("SCOPE_user:read");
            auth.requestMatchers(HttpMethod.POST , "/api/v1/users/**").hasAnyAuthority("SCOPE_user:write");
            auth.requestMatchers(HttpMethod.DELETE , "/api/v1/users/**").hasAnyAuthority("SCOPE_user:delete");
            auth.requestMatchers(HttpMethod.GET , "/api/v1/users/**").hasAnyAuthority("SCOPE_user:update");
            auth.requestMatchers(HttpMethod.GET , "/api/v1/users/**").hasAnyAuthority("SCOPE_account:read");
            auth.anyRequest().authenticated();
        });
//        http.httpBasic();
//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //Make security http STATELESS
        http.oauth2ResourceServer(a->a.jwt());
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.exceptionHandling().authenticationEntryPoint(customerAuthentionEntryPoint);
        return http.build();
    }


    @Bean
    public KeyPair keyPair() throws NoSuchAlgorithmException{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();

    }
    @Bean
    public RSAKey rsaKey (KeyPair keyPair){
        return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())
                .privateKey(keyPair.getPrivate())
                .keyID(UUID.randomUUID().toString())
                .build();
    }
    @Bean
    public JwtDecoder jwtDecoder(RSAKey rsaKey)throws JOSEException {
        return NimbusJwtDecoder.withPublicKey(rsaKey.toRSAPublicKey()).build();
    }
    //create Jwt token
    @Bean
    public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
        return new NimbusJwtEncoder(jwkSource);
    }
//vitrify jwt token
    @Bean
    public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
        var jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, context) -> jwkSelector.select(jwkSet);
    }




}
