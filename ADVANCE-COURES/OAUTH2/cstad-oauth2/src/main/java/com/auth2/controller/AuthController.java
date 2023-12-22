package com.auth2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("/public")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String get() {
        return "public this okay".toUpperCase();
    }

    @GetMapping("/private")
    @PreAuthorize("hasAnyRole('USER')")
    public String getPrivate() {
        return "private this okay".toUpperCase();
    }

    @GetMapping("/public1")
//    @PreAuthorize("hasAuthority('ROLE_read')")
    public String getA() {
        return "public this okay".toUpperCase();
    }
}
