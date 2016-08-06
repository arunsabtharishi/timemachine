package com.dragonfly.timemachine.contents;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class DeleteContentsRequest {
	@NotNull
	List<String> ids;
}
