package com.dragonfly.timemachine.contents;

import java.sql.Date;

public class InsertContentsRequest {
	String contents;
	
	Date contentDate;
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getContentDate() {
		return contentDate;
	}

	public void setContentDate(Date contentDate) {
		this.contentDate = contentDate;
	}
}
