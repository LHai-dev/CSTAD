package com.AuthorizationServer.inti;

import com.AuthorizationServer.entities.Client;
import com.AuthorizationServer.entities.RedirectUrl;
import com.AuthorizationServer.entities.Scope;
import com.AuthorizationServer.entities.User;
import com.AuthorizationServer.repositoies.ClientRepository;
import com.AuthorizationServer.repositoies.RedirectUrlRepository;
import com.AuthorizationServer.repositoies.ScopesRepository;
import com.AuthorizationServer.repositoies.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataInitialization
{
        private final ClientRepository clientRepository;
        private final UserRepository userRepository;
        private final RedirectUrlRepository redirectUrlRepository;
        private final ScopesRepository scopesRepository;
        @PostConstruct
        void init(){
//                User user = new User();
//                user.setPassword("admin");
//                user.setUsername("admin");
//
//                User user1 = new User();
//                user1.setPassword("LimHai");
//                user1.setUsername("LimHai");
//
//                User user2 = new User();
//                user2.setPassword("heng");
//                user2.setUsername("heng");
//
//                User user3 = new User();
//                user3.setPassword("sai");
//                user3.setUsername("sai");
//
//                User user4 = new User();
//                user4.setPassword("admin");
//                user4.setUsername("LimHai");
//
//                User user5 = new User();
//                user5.setPassword("admin");
//                user5.setUsername("LimHai");
//                userRepository.saveAll(List.of(user,user1,user2,user3,user4,user5));
//
//                Client client = new Client();
//                RedirectUrl redirectUrl = new RedirectUrl();
//                redirectUrl.setUrl("http://example.com/auth");
//                RedirectUrl redirectUrl1 = new RedirectUrl();
//                redirectUrl1.setUrl("http://example1.com/auth");
//                RedirectUrl redirectUrl2 = new RedirectUrl();
//                redirectUrl2.setUrl("http://example1.com/auth");
//                redirectUrlRepository.saveAll(List.of(redirectUrl,redirectUrl1,redirectUrl2));

//                Scope scope = new Scope();
//                scope.setScope("openId");
//
//                Scope scope1 = new Scope();
//                scope1.setScope("user.read");

//                scopesRepository.saveAll(List.of(scope,scope1));

//                User admin = User.().password("admin").username("admin").build();
//                User user = User.builder().password("hai").username("LimHai").build();
//                User user1 = User.builder().password("admin").username("newJeans").build();
//                User user2 = User.builder().password("admin").username("Sai").build();
//                User user3 = User.builder().password("admin").username("Minji").build();
//                userRepository.saveAll(List.of(admin,user,user1,user2,user3));
//                clientRepository.saveAll(List.of(admin,user,user1,user2,user3));
//                Client client = Client.builder().clientId("1").clientTokenSettings().build();



        }

}
