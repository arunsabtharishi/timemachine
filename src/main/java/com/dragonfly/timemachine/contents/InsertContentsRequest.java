package com.dragonfly.timemachine.contents;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class InsertContentsRequest {
	@NotNull
    String contents;

    String contentDate;
    
    @NotNull
    String userName;

}