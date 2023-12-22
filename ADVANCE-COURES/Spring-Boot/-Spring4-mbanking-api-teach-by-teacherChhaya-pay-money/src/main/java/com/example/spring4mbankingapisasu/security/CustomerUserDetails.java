package com.example.spring4mbankingapisasu.security;

import com.example.spring4mbankingapisasu.auth.Authority;
import com.example.spring4mbankingapisasu.user.Role;
import com.example.spring4mbankingapisasu.user.User;
import lombok.*;
import org.apache.ibatis.javassist.Loader;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerUserDetails implements UserDetails {
    private User user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Role role:user.getRoles()){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getAuthority()));
            for (Authority authority: role.getAuthorities()){
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));

            }
        }
        return simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
