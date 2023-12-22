package co.hai.microservices.core.user.api.web;


import lombok.Builder;

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
