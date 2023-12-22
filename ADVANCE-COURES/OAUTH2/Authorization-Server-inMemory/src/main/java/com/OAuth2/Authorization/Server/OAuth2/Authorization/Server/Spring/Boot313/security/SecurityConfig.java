package com.OAuth2.Authorization.Server.OAuth2.Authorization.Server.Spring.Boot313.security;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import java.rmi.registry.Registry;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     *  this code defines a separate security filter chain for OAuth2-specific configurations
     *  , including authorization server settings and OIDC integration.
     *  It's configured with a lower order priority than the previous security filter chain,
     *  indicating that it should be executed before the other filter chain.
     *  This allows you to have different security configurations for different parts of your application,
     *  with each filter chain handling specific security concerns.
     * **/
    @Bean
    @Order(1)
    public SecurityFilterChain webFilterChainForOAuth(HttpSecurity httpSecurity) throws Exception {
        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(httpSecurity);
        httpSecurity.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
                .oidc(Customizer.withDefaults());
        httpSecurity.exceptionHandling(e -> e.authenticationEntryPoint(
                new LoginUrlAuthenticationEntryPoint("/login")
        ));

        return httpSecurity.build();
    }

/**
 *  defines a security filter chain that requires authentication for all incoming HTTP requests and sets up form-based login for the application.
 *  The @Order(2) annotation indicates the priority of this filter chain, and you can have multiple security filter chains with different configurations in your application,
 *  each with its own order to control the order of execution.
 *
 * */
    @Bean
    @Order(2)
    public SecurityFilterChain appSecurity(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

    /**
     * This code is useful for testing and development purposes,
     * as it allows you to configure user accounts with roles and authorities without the need for an external user database.
     * However, in a production environment,
     * user details are typically stored in a secure and persistent data store (such as a database)
     * , and a custom UserDetailsService implementation is used to retrieve user information from that data store.
     * */
    @Bean
    public UserDetailsService userDetailsService() {
        var user = User.withUsername("hai")
                .password("hai1722")
                .authorities("read")
                .roles("VIEWER")
                .build();

        var adminUser = User.withUsername("joji")
                .password("joji123")
                .authorities("read")
                .roles("VIEWER","ADMIN")
                .build();
        var hackUser = User.withUsername("GGG")
                .password("joji123")
                .authorities("read")
                .roles("HACK")
                .build();


        return new InMemoryUserDetailsManager(user,adminUser,hackUser);
    }

    //only for dev , dont use same production
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
        /**
         * this code sets up a Spring Bean that provides an in-memory repository of registered OAuth2 clients.
         * These clients are used for various OAuth2 authorization flows
         * , and the code demonstrates the configuration of a sample OAuth2 client with various settings,
         * including client authentication methods and supported grant types.
         *
         *
         * **/
    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        var register = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("public-client-react-app")
                .clientSecret("secret") //store in secret manager
                .scope(OidcScopes.OPENID)
                .scope(OidcScopes.PROFILE)
                .redirectUri("http://127.0.0.1:9080/login/oauth2/code/public-client-react-app")
                .clientAuthenticationMethod(ClientAuthenticationMethod.NONE)//public client
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)
                .authorizationGrantTypes(
                        granType -> {

                            granType.add(AuthorizationGrantType.AUTHORIZATION_CODE);
                            granType.add(AuthorizationGrantType.REFRESH_TOKEN);
                            granType.add(AuthorizationGrantType.CLIENT_CREDENTIALS);
                        }


                ).clientSettings(ClientSettings.builder().requireProofKey(true).build())
                .build();
        return new InMemoryRegisteredClientRepository(register);

    }
/**
 *  this code provides a Spring Bean that encapsulates authorization server settings for your application,
 *  and it returns a default or empty AuthorizationServerSettings instance. You would typically use this Bean to
 *  configure and customize the behavior of your authorization server according to your application's requirements.
 * **/
    @Bean
    public AuthorizationServerSettings authorizationServerSettings (){
        return AuthorizationServerSettings.builder().build();
    }


    /**
     *
     *  this code sets up a source of JWKs for use in cryptographic operations within the application.
     *  These keys can be used for various purposes, such as signing and verifying JWTs or encrypting and decrypting data.
     *  The keys are generated as an RSA key pair with a specific key size, and a random KID is associated with the public key in the JWK.
     *  This jwkSource Bean can be used to provide keys for JWT validation and other cryptographic operations in your application.
     *
     * */
    @Bean
    public JWKSource<SecurityContext> jwkSource() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);

        var keys  = keyPairGenerator.generateKeyPair();
        var publicKey = (RSAPublicKey)keys.getPublic();
        var privateKey = keys.getPrivate();

        var reaKey = new RSAKey.Builder(publicKey)
                .privateKey(privateKey)
                .keyID(UUID.randomUUID().toString())
                .build();
        JWKSet jwkSet = new JWKSet(reaKey);
        return new ImmutableJWKSet<>(jwkSet);
    }


    /**
     * this code configures a
     * JwtDecoder Bean for decoding JWTs, and it likely leverages the OAuth2AuthorizationServerConfiguration
     * to create the JwtDecoder instance with the necessary settings and keys (JWKs) for JWT validation.
     *
     *
     * */
    @Bean
    public JwtDecoder jwtDecoder (JWKSource<SecurityContext> jwkSource){
        return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource);
    }




//    -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=CustomizerAccessToken-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    /**
     *
     * this code customizes the JWT encoding process for access tokens
     * in an OAuth2 authentication system by including the user's authorities
     * as a claim in the JWT token. This can be useful for controlling access
     * to resources based on the user's roles and permissions.
     *
     * **/

    @Bean
    public OAuth2TokenCustomizer<JwtEncodingContext> jwtEncodingContextOAuth2TokenCustomizer(){
        return context -> {
            if (context.getTokenType().getValue().equals(OAuth2TokenType.ACCESS_TOKEN.getValue())){
                Authentication principal  = context.getPrincipal();
              var authorities =  principal.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toSet());
              context.getClaims().claim("authorities",authorities);

            }

        };
    }


}
