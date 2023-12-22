package com.auth2.init;

import com.auth2.entity.Authority;
import com.auth2.entity.User;
import com.auth2.repository.AuthorityRepository;
import com.auth2.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitialization {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;


    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    void init() {

        Authority read = Authority.builder().name("read").build();
        Authority write = Authority.builder().name("write").build();
        Authority update = Authority.builder().name("update").build();
        Authority delete = Authority.builder().name("delete").build();

        authorityRepository.saveAll(List.of(read, write, update, delete));

        User admin = User.builder()
                .uuid(UUID.randomUUID().toString())
                .username("admin")
                .email("admin@localhost.com")
                .password(passwordEncoder.encode("admin"))
                .familyName("Admin")
                .givenName("Localhost")
                .gender("Male")
                .jobTitle("Administrator")
                .dob(LocalDate.of(1998, 8, 4))
                .authorities(Set.of(read, write, update, delete))
                .build();

        User kangchi = User.builder()
                .uuid(UUID.randomUUID().toString())
                .username("limhai")
                .email("limhai@localhost.com")
                .password(passwordEncoder.encode("hai172212"))
                .familyName("koko")
                .givenName("Mey")
                .gender("Male")
                .jobTitle("IT Instructor")
                .dob(LocalDate.of(1998, 8, 4))
                .authorities(Set.of(read, write))
                .build();

        userRepository.save(admin);
        userRepository.save(kangchi);

    }

}