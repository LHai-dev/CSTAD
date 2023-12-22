package co.hai.microservices.core.user.api.web;


import lombok.Builder;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

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
