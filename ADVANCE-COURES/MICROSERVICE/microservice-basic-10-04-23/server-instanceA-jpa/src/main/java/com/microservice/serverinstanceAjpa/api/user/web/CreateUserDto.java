package com.microservice.serverinstanceAjpa.api.user.web;


import lombok.Builder;

import java.util.List;

@Builder
public record CreateUserDto(
        Long id,
        String uuid,
        String name,
        String password,
        String email,
        String phoneNumber,
        Boolean isDelete,
        Boolean isStudent,
        Boolean isVerified
) {

}
