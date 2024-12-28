package com.guglani.test.Production.ready.Features.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Audited
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity {

    @CreationTimestamp
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime autoUpdatedTime;

    @LastModifiedBy
    private String updatedBy;

    @CreatedBy
    private String createdBy;
}
