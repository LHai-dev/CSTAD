package com.SpringFrameworkHomeworkInstruction.Spring.api.user;

import com.SpringFrameworkHomeworkInstruction.Spring.api.userAccount.UserAccount;
import com.SpringFrameworkHomeworkInstruction.Spring.api.userRole.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 266)
    private String name;
    private String password;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_delete" )
    private Boolean isDelete;

    @Column(name = "is_student")
    private Boolean isStudent;

    /*@GeneratedValue(generator = "uuid2", strategy = GenerationType.UUID)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")*/
    @Column(name = "uuid", columnDefinition = "VARCHAR(255)")
    private String uuid;


    @Column(name = "is_verified")
    private Boolean isVerified;

    @OneToMany(mappedBy = "user")
    List<UserAccount> userAccounts;
    @OneToMany(mappedBy ="user")
    List<UserRole>userRoles;
}
