package com.microservice.serverinstanceAjpa.api.user.web;


import lombok.Builder;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Relation(collectionRelation = "users", itemRelation = "user")
@Builder
public record UserDto(
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
