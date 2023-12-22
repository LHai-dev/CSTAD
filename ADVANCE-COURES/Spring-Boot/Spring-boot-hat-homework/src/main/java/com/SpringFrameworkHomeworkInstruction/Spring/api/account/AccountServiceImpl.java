package com.SpringFrameworkHomeworkInstruction.Spring.api.account;

import com.SpringFrameworkHomeworkInstruction.Spring.api.account.web.CreateAccountDto;
import com.SpringFrameworkHomeworkInstruction.Spring.api.account.web.LimitTransferAccountDto;
import com.SpringFrameworkHomeworkInstruction.Spring.api.account.web.RenameAccountDto;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.User;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountModelAssembler accountModelAssembler;
    private final AccountRepository accountRepository;

    @Override
    public EntityModel<?> findByUuidAccount(String uuid) {
        Account account = accountRepository.findByUuid(uuid).orElseThrow();
        return accountModelAssembler.toModel(account);
    }

    @Override
    public CollectionModel<?> findAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return accountModelAssembler.toCollectionModel(accounts);
    }

    @Override
    public EntityModel<?> disableAccount(String uuid) {
        Account existingUser = accountRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        existingUser.setStatus(true); // Disable the user
        BeanUtils.copyProperties(existingUser, uuid);
        return accountModelAssembler.toModel(existingUser);
    }

    @Override
    public Account CreateAccount(CreateAccountDto createAccountDto) {
        Account account = AccountMapper.INSTANCE.accountToCreateAccount(createAccountDto);
        account.setUuid(UUID.randomUUID().toString());
        return accountRepository.save(account);
    }

    @Override
    public Account renameAccount(String uuid, RenameAccountDto renameAccountDto) {
        Account existingUser = accountRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Account account = AccountMapper.INSTANCE.renameAccountDtoToAccount(renameAccountDto);
        BeanUtils.copyProperties(renameAccountDto, existingUser, uuid);
        return accountRepository.save(account);
    }

    @Override
    public Account limitTransfer(String uuid, LimitTransferAccountDto limitTransferAccountDto) {
        Account existingUser = accountRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Account account = AccountMapper.INSTANCE.limitTransferAccountDtoToAccount(limitTransferAccountDto);
        BeanUtils.copyProperties(limitTransferAccountDto, existingUser, uuid);
        return accountRepository.save(account);
    }


}
