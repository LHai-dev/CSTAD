package com.SpringFrameworkHomeworkInstruction.Spring.api.transaction;

import com.SpringFrameworkHomeworkInstruction.Spring.api.account.Account;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Columns;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedStoredProcedureQuery(name = "TRANSFER",
        procedureName = "TRANSFER", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sender", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "receiver", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "amount", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "remark", type = String.class),
})
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(columnDefinition = "NUMERIC")
    private Double amount;

    private String remark;
    @Column(name = "student_card_no")
    private String studentCardNo;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT uuid_generate_v4()")
    private UUID uuid;

    @CreatedDate
    @Column(name = "transaction_at", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime transactionAt;

    @ManyToOne
    @JoinColumn(name = "receiver_act_id")
    private Account receiverActId;

    @ManyToOne
    @JoinColumn(name = "sender_act_id")
    private Account senderActId;

}
