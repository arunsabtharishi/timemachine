package com.dragonfly.timemachine.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER_CONTENTS")
public class UserContents extends Model {
	@Column(name = "user_name")
	String userName;
	
	@Column(name = "CONTENT")
	String content;
	
	@Column(name = "CONTENT_DATE")
	Date contentDate;
	
	@Column(name = "CREATED_DATE")
	Date createdDate;
	
	@Column(name = "CREATED_BY")
	String createdBy;
	
	@Column(name = "UPDATED_DATE")
	Date updatedDate;
	
	@Column(name = "UPDATED_BY")
	String updatedBy;
}
