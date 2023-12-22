package com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount;

import com.SpringFrameworkHomeworkInstruction.Spring.api.account.Account;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.User;
import com.SpringFrameworkHomeworkInstruction.Spring.base.AuditEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccount extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_disabled")
    private Boolean isDisabled;

    @ManyToOne
    @JsonIgnore
    private User user;
    @ManyToOne
    @JsonIgnore
    private Account account;
}
