package com.dragonfly.timemachine.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CONTENTS")
public class Contents extends Model {
	@Column(name = "USER_NAME")
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
