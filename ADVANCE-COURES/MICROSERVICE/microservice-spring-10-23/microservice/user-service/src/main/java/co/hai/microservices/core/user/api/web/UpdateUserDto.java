package co.hai.microservices.core.user.api.web;

import lombok.Builder;
@Builder
public record UpdateUserDto(
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
