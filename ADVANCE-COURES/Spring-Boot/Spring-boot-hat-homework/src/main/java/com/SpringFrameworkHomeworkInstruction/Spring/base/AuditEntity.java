package com.SpringFrameworkHomeworkInstruction.Spring.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity {
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime dateCreated;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime dateUpdated;
}
