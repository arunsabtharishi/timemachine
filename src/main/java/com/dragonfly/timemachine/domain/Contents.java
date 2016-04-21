package com.dragonfly.timemachine.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.domain.Auditable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "CONTENTS")
public class Contents extends Model {
    @Column(name = "USER_NAME")
    String userName;

    @Column(name = "CONTENT")
    String content;

    @Column(name = "CONTENT_DATE")
    Date contentDate;

}
