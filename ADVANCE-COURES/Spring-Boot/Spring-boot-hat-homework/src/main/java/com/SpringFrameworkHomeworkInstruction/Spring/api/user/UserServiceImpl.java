package com.SpringFrameworkHomeworkInstruction.Spring.api.user;

import com.SpringFrameworkHomeworkInstruction.Spring.api.account.Account;
import com.SpringFrameworkHomeworkInstruction.Spring.api.account.AccountModelAssembler;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.web.CreateUserDto;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.web.UpdateUserDto;
import com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.UserAccount;
import com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.UserAccountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserModelAssembler userModelAssembler;
    private final AccountModelAssembler accountModelAssembler;

    private final UserAccountRepository userAccountRepository;
    @Override
    public User CreateUser(CreateUserDto createUserDto) {
        User user =  UserMapper.INSTANCE.toEntity(createUserDto);
        user.setUuid(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public CollectionModel<?> findAllUser() {
        List<User> users = userRepository.findByIsDeleteFalse();
        return userModelAssembler.toCollectionModel(users);
    }

    @Override
    public EntityModel<?> findUserByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid).orElseThrow();
        return userModelAssembler.toModel(user);
    }

    @Override
    public User disableUser(String uuid) {
        User existingUser = userRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        existingUser.setIsDelete(true); // Disable the user
        BeanUtils.copyProperties(existingUser,uuid);
        return userRepository.save(existingUser);
    }

    @Override
    public User updateUserByUuid(String uuid, UpdateUserDto updatedUser) {
     User user =   userRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));
        BeanUtils.copyProperties(updatedUser,user,uuid);

        return userRepository.save(user);
    }

    @Override
    public void deleteUserByUuid(String uuid) {
     User user =  userRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));

     userRepository.delete(user);
    }

    @Override
    public Account getFindByUser_UuidAndAccount_Uuid(String userUuid, String accountUuid) {
     userRepository.findByUuid(userUuid).orElseThrow();
        Optional<UserAccount> userAccount = userAccountRepository.findByUser_UuidAndAccount_Uuid(userUuid,accountUuid);
        if(userAccount.isPresent()){
            return userAccount.get().getAccount();
        }else {

            throw new EntityNotFoundException();
        }
    }

    @Override
    public  CollectionModel<?>  getUserAccountsByUuid(String uuid) {
        List<UserAccount> userAccounts = userAccountRepository.findByUserUuid(uuid);
        List<Account> accounts = userAccounts.stream()
                .map(UserAccount::getAccount)
                .collect(Collectors.toList());
        return accountModelAssembler.toCollectionModel(accounts);
    }


}
