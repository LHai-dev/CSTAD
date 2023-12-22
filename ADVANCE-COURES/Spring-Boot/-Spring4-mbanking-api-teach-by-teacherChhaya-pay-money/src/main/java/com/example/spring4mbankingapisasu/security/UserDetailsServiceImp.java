package com.example.spring4mbankingapisasu.security;

import com.example.spring4mbankingapisasu.auth.AuthMapper;
import com.example.spring4mbankingapisasu.auth.Authority;
import com.example.spring4mbankingapisasu.user.Role;
import com.example.spring4mbankingapisasu.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImp implements UserDetailsService {
    private final AuthMapper authMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("hellovviwruf");
        System.out.println(authMapper.loadUserByUserName(username));
        User user = authMapper.loadUserByUserName(username).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND , "USer is not found"));
        for (Role role:user.getRoles()){
            for (Authority authority:role.getAuthorities()){
                System.out.println(authority.getName());
            }
        }
        CustomerUserDetails customerUserDetails = new CustomerUserDetails();
        customerUserDetails.setUser(user);
        log.info("Customer User Detail: {}",customerUserDetails.getAuthorities());


        return customerUserDetails;
    }
}
