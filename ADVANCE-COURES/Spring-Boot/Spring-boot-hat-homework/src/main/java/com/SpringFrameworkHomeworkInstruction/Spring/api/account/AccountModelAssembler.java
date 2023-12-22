package com.SpringFrameworkHomeworkInstruction.Spring.api.account;

import com.SpringFrameworkHomeworkInstruction.Spring.api.account.web.AccountController;
import com.SpringFrameworkHomeworkInstruction.Spring.api.account.web.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
@Configuration
public class AccountModelAssembler extends RepresentationModelAssemblerSupport<Account, EntityModel<AccountDto>> {

    private AccountMapper accountMapper;
    @Autowired
    public void setAccountMapper(AccountMapper accountMapper){
        this.accountMapper = accountMapper;
    }

    public AccountModelAssembler() {
        super(AccountController.class, (Class<EntityModel<AccountDto>>)(Class<?>) EntityModel.class);
    }

    @Override
    public EntityModel<AccountDto> toModel(Account entity) {
        AccountDto accountDto = accountMapper.mapAccountToAccountDto(entity);
        Link link = linkTo(methodOn(AccountController.class).findAccountById(entity.getUuid())).withSelfRel();
        Link link1 = linkTo(methodOn(AccountController.class).findAccount()).withRel(IanaLinkRelations.COLLECTION);
        return EntityModel.of(accountDto,link,link1);
    }

    @Override
    public CollectionModel<EntityModel<AccountDto>> toCollectionModel(Iterable<? extends Account> entities) {
        return super.toCollectionModel(entities);
    }


//    private List<AccountDto> toOrderDto(List<Account> accounts) {
//        if (accounts.isEmpty())
//            return Collections.emptyList();
//
//        return accounts.stream()
//                .map(order -> AccountDto.builder()
//
//                        .actName(order.getActName())
//                        .pin(order.getPin())
//                        .build()
//                        .add(linkTo(
//                                methodOn(AccountController.class)
//                                        .getProductById(order.getId()))
//                                .withSelfRel()))
//                .collect(Collectors.toList());
//    }
}
