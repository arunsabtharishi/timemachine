package com.dragonfly.timemachine.facade;

import java.util.List;

import com.dragonfly.timemachine.contents.InsertContentsRequest;
import com.dragonfly.timemachine.contents.ReadRequest;
import com.dragonfly.timemachine.contents.UpdateContentsRequest;
import com.dragonfly.timemachine.domain.Contents;

public interface ContentsDataFacade {
	void createContentsFacade(InsertContentsRequest insertContentsRequest);
	
	List<Contents> readContentsFacade(ReadRequest readRequest);
	
	void updateContentsFacade(UpdateContentsRequest updateContentsRequest, String id);
	
	void deleteContentsFacade(List<String> ids);
}
