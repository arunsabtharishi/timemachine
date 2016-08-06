package com.dragonfly.timemachine.contents;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class UpdateContentsRequest {
	@NotNull
    String updatedContents;
	
	@NotNull
    String updatedContentDate;

}
