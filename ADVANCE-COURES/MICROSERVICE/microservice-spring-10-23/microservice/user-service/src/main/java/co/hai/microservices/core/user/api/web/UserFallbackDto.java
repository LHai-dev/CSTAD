package co.hai.microservices.core.user.api.web;

import lombok.Builder;
import lombok.Data;

@Data
public class UserFallbackDto {
    private Long id;
    private String uuid;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private Boolean isDelete;
    private Boolean isStudent;
    private Boolean isVerified;

}
