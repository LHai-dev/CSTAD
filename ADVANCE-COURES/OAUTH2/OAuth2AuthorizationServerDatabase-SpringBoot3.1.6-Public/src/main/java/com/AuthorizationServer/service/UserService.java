package com.AuthorizationServer.service;

import com.AuthorizationServer.model.SecurityUser;
import com.AuthorizationServer.repositoies.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user  =userRepository.findUserByUsername(username);
        return user.map(SecurityUser::new)
                .orElseThrow(()->new UsernameNotFoundException("Username not found"));
    }
}
