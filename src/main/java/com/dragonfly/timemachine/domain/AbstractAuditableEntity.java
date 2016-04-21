package com.dragonfly.timemachine.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableEntity extends AbstractPersistable<Integer> implements Auditable<String, Integer> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Version
    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "CREATED_BY", updatable = false)
    @Size(min = 1, max = 255)
    @CreatedBy
    private String createdBy;

    @Column(name = "CREATED_DATE", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate = new Date();

    @Column(name = "UPDATED_BY")
    @Size(min = 1, max = 255)
    @LastModifiedBy
    private String lastModifiedBy;

    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date lastModifiedDate;

    @Override
    public String toString() {
        return "";
    }
}