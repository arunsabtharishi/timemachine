package com.dragonfly.timemachine.contents;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class ReadRequest {	
	@NotNull
	String contentDate;
	
	@NotNull
	String userName;
}
