package com.dragonfly.timemachine.contents;

import java.sql.Date;

public class InsertContentsRequest {
	String userContents;
	
	Date contentDate;
	
	public String getUserContents() {
		return userContents;
	}

	public void setUserContents(String userContents) {
		this.userContents = userContents;
	}

	public Date getContentDate() {
		return contentDate;
	}

	public void setContentDate(Date contentDate) {
		this.contentDate = contentDate;
	}
}
