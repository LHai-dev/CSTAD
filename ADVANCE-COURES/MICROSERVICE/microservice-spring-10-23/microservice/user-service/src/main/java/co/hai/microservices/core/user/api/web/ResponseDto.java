package co.hai.microservices.core.user.api.web;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private DepartmentFallbackDto department;
    private UserFallbackDto user;
}
