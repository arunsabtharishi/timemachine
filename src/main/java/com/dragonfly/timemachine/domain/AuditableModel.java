package com.dragonfly.timemachine.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableModel {


    @Column(name = "CREATED_BY", updatable = false)
    @Size(min = 1, max = 255)
    @CreatedBy
    private String createdBy;

    @Column(name = "CREATED_DATE", updatable = false)
    @CreatedDate
    private Date createdDate = new Date();

    @Column(name = "UPDATED_BY")
    @Size(min = 1, max = 255)
    @LastModifiedBy
    private String lastModifiedBy;

    @Column(name = "UPDATED_DATE")
    @LastModifiedDate
    private Date lastModifiedDate;

    @Override
    public String toString() {
        return "";
    }

}