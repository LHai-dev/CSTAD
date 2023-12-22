package com.SpringFrameworkHomeworkInstruction.Spring.api.init;

import com.SpringFrameworkHomeworkInstruction.Spring.api.account.Account;
import com.SpringFrameworkHomeworkInstruction.Spring.api.account.AccountRepository;
import com.SpringFrameworkHomeworkInstruction.Spring.api.transaction.Transaction;
import com.SpringFrameworkHomeworkInstruction.Spring.api.transaction.TransactionRepository;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.User;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.UserRepository;
import com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.UserAccount;
import com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.UserAccountRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitialization {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final UserAccountRepository userAccountRepository;
    private final TransactionRepository transactionRepository ;
    @PostConstruct
    void init(){
        System.out.println("Start initialize data...");

//        Account      account = Account.builder().actName("LimHai").actNo("172212").pin("323445").transferLimit(243.00).balance(1000.0).uuid(UUID.randomUUID().toString()).build();
//        Account account1 = Account.builder().actName("heng").actNo("172212").pin("323445").transferLimit(213.00).balance(1000.0).uuid(UUID.randomUUID().toString()).build();
//        Account account2 = Account.builder().actName("hong").actNo("172212").pin("323445").transferLimit(223.00).balance(1000.0).uuid(UUID.randomUUID().toString()).build();
//        Account account3 = Account.builder().actName("Heang").actNo("172212").pin("323445").transferLimit(233.00).balance(1000.0).uuid(UUID.randomUUID().toString()).build();
//        //Save account
//        accountRepository.saveAll(List.of(account,account1,account2,account3));
//
//        User user = User.builder().email("limhaifc@gmail.com").name("LimHai").password(String.valueOf(UUID.randomUUID())).isStudent(true).isDelete(false).phoneNumber("012349929").uuid(String.valueOf(UUID.randomUUID())).build();
//        User user1 = User.builder().email("heng@gmail.com").name("heng").password(String.valueOf(UUID.randomUUID())).isStudent(true).isDelete(false).phoneNumber("012433434").uuid(String.valueOf(UUID.randomUUID())).build();
//        User user2 = User.builder().email("hong@gmail.com").name("hong").password(String.valueOf(UUID.randomUUID())).isStudent(true).isDelete(false).phoneNumber("098334334").uuid(String.valueOf(UUID.randomUUID())).build();
//        User user3 = User.builder().email("hack@gmail.com").name("heang").password(String.valueOf(UUID.randomUUID())).isStudent(true).isDelete(false).phoneNumber("02134343").uuid(String.valueOf(UUID.randomUUID())).build();
//
//        userRepository.saveAll(List.of(user,user1,user2,user3));
//
//        UserAccount userAccount = UserAccount.builder()
//                .user(user)
//                .account(account)
//                .isDisabled(true).build();
//        UserAccount userAccount2 = UserAccount.builder().isDisabled(true).build();
//        UserAccount userAccount3 = UserAccount.builder().isDisabled(true).build();
//        UserAccount userAccount4 = UserAccount.builder().isDisabled(true).build();
//        UserAccount userAccount5 = UserAccount.builder().isDisabled(true).build();
//        userAccountRepository.saveAll(List.of(userAccount,userAccount2,userAccount3,userAccount4,userAccount5));
//
//        Transaction transaction = Transaction.builder().transactionAt(LocalDateTime.now()).amount(1000.0).uuid(UUID.randomUUID()).name("Limhai").remark("hello it your tran").studentCardNo("1").build();
//        Transaction transaction2 = Transaction.builder().transactionAt(LocalDateTime.now()).amount(1000.0).uuid(UUID.randomUUID()).name("heng").remark("hello it your tran").studentCardNo("12323").build();
//        Transaction transaction3 = Transaction.builder().transactionAt(LocalDateTime.now()).amount(1000.0).uuid(UUID.randomUUID()).name("he").remark("hello it your tran").studentCardNo("12434").build();
//        Transaction transaction4 = Transaction.builder().transactionAt(LocalDateTime.now()).amount(1000.0).uuid(UUID.randomUUID()).name("No").remark("hello it your tran").studentCardNo("1w4e").build();
//        Transaction transaction5 = Transaction.builder().transactionAt(LocalDateTime.now()).amount(1000.0).uuid(UUID.randomUUID()).name("kaka").remark("hello it your tran").studentCardNo("1").build();
//        transactionRepository.saveAll(List.of(transaction,transaction2,transaction3,transaction4,transaction5));
    }

}
