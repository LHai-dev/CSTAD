package com.SpringFrameworkHomeworkInstruction.Spring.api.account;

import com.SpringFrameworkHomeworkInstruction.Spring.api.accountType.AccountType;
import com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.UserAccount;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "act_name")
    private String actName;
    @Column(name = "act_no")
    private String actNo;

    private Double balance;

    @Column(name = "transfer_limit", columnDefinition = "NUMERIC")
    private Double transferLimit;

    private String pin;
//    @GeneratedValue(generator = "uuid2", strategy = GenerationType.UUID)
//    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", columnDefinition = "VARCHAR(255)")
    private String uuid;

    private Boolean status;

    @OneToMany(mappedBy = "account")
    private List<UserAccount> userAccounts;

    @ManyToOne
   private AccountType accountTypes ;
}
