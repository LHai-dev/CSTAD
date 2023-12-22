package com.SpringFrameworkHomeworkInstruction.Spring.api.userRole;

import com.SpringFrameworkHomeworkInstruction.Spring.api.role.Role;
import com.SpringFrameworkHomeworkInstruction.Spring.api.user.User;
import com.SpringFrameworkHomeworkInstruction.Spring.base.AuditEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Role role;
}
