package co.hai.microservices.core.user.api;






import co.hai.microservices.core.user.api.web.CreateUserDto;
import co.hai.microservices.core.user.api.web.DepartmentFallbackDto;
import co.hai.microservices.core.user.api.web.UserDto;
import co.hai.microservices.core.user.api.web.UserFallbackDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
@Configuration
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto toUserCreateDto(CreateUserDto createUserDto);
    CreateUserDto toUserDto(UserDto userDto);

    User toEntity(CreateUserDto createUserDto);

    UserFallbackDto toDto(User user);

    UserDto mapUserToUserDto(User user);

    List<UserDto> mapProductsToProductDtoList(List<User> user);
}
