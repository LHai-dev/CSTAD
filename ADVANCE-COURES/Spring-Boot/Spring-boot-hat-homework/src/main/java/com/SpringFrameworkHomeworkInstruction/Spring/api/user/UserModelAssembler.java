package com.SpringFrameworkHomeworkInstruction.Spring.api.user;

import com.SpringFrameworkHomeworkInstruction.Spring.api.user.web.UserController;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.web.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class UserModelAssembler extends RepresentationModelAssemblerSupport<User, EntityModel<UserDto>> {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }

//    @SuppressWarnings("unchecked")
    public UserModelAssembler() {
        super(UserController.class, (Class<EntityModel<UserDto>>) (Class<?>) EntityModel.class);    }




    @Override
    public EntityModel<UserDto> toModel(User entity) {
        UserDto userDto = userMapper.mapUserToUserDto(entity);
        Link selfLink =linkTo(methodOn(UserController.class).findUsersByUuid(entity.getUuid())).withSelfRel();
        Link collectionLink  =linkTo(methodOn(UserController.class).findUsers()).withRel(IanaLinkRelations.COLLECTION);

        return EntityModel.of(userDto,selfLink,collectionLink);
    }

    @Override
    public CollectionModel<EntityModel<UserDto>> toCollectionModel(Iterable<? extends User> entities) {
        return super.toCollectionModel(entities);
    }
}
