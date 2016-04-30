package com.dragonfly.timemachine.contents;

import java.util.List;

import lombok.Getter;

@Getter
public class DeleteContentsRequest {
	List<String> ids;
}
