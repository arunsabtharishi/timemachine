package com.dragonfly.timemachine.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class Model extends AuditableModel {

    
    private static final long serialVersionUID = 1L;
    public static final int ID_LENGTH = 36;
    public static final int ENUM_LENGTH = 256;

    @Autowired(required = true)
	@Id
    @Column(name = "ID", updatable = false)
    @Size(max = ID_LENGTH)
    @GeneratedValue(generator = "UuidOrAssignedGenerator")
    @GenericGenerator(name = "UuidOrAssignedGenerator", strategy = "com.dragonfly.timemachine.util.jpa.UuidOrAssignedGenerator", parameters = { @Parameter(name = "strategy", value = "uuid2") })
    private String id;
    
    
}