package com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount;

import com.SpringFrameworkHomeworkInstruction.Spring.api.user.UserMapper;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.web.UserDto;
import com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.web.UserAccountController;
import com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.web.UserAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Configuration
public class UserAccountModelAssembler extends RepresentationModelAssemblerSupport<UserAccount, EntityModel<UserAccountDto>> {

    private UserAccountMapper userAccountMapper;

    @Autowired
    public void setUserMapper(UserAccountMapper userAccountMapper){
        this.userAccountMapper = userAccountMapper;
    }


    public UserAccountModelAssembler() {
        super(UserAccountController.class,(Class<EntityModel<UserAccountDto>>) (Class<?>) EntityModel.class);
    }


    @Override
    public EntityModel<UserAccountDto> toModel(UserAccount entity) {
        UserAccountDto userAccountDto = userAccountMapper.mapUserAccountToUserAccountDto(entity);
        Link sefLink = linkTo(methodOn(UserAccountController.class).findUserAccountById(entity.getId())).withSelfRel();
        Link collectionModel = linkTo(methodOn(UserAccountController.class).findUserAccount()).withRel(IanaLinkRelations.COLLECTION);


        return EntityModel.of(userAccountDto,sefLink,collectionModel);
    }

    @Override
    public CollectionModel<EntityModel<UserAccountDto>> toCollectionModel(Iterable<? extends UserAccount> entities) {
        return super.toCollectionModel(entities);
    }
}
