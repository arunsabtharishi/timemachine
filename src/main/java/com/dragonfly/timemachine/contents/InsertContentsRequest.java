package com.dragonfly.timemachine.contents;

import java.sql.Date;

public class InsertContentsRequest {
	String contents;
	
	String contentDate;
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getContentDate() {
		return contentDate;
	}

	public void setContentDate(String contentDate) {
		this.contentDate = contentDate;
	}
}
