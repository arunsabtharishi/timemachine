package com.dragonfly.timemachine.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
@Table(name = "CONTENTS")
public class Contents extends Model {
	@Column(name = "USER_NAME")
	String userName;
	
	@Column(name = "CONTENT")
	String content;
	
	@Column(name = "CONTENT_DATE")
	Date contentDate;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getContentDate() {
		return contentDate;
	}

	public void setContentDate(Date contentDate) {
		this.contentDate = contentDate;
	}
}
