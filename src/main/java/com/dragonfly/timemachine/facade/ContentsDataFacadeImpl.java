package com.dragonfly.timemachine.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragonfly.timemachine.contents.InsertContentsRequest;
import com.dragonfly.timemachine.contents.ReadRequest;
import com.dragonfly.timemachine.contents.UpdateContentsRequest;
import com.dragonfly.timemachine.domain.Contents;
import com.dragonfly.timemachine.service.ContentsDataService;

@Service
public class ContentsDataFacadeImpl implements ContentsDataFacade {
	@Autowired
	ContentsDataService contentsDataService;
	
	@Override
	public void createContentsFacade(InsertContentsRequest insertContentsRequest) {
		contentsDataService.createContents(insertContentsRequest);
	}

	@Override
	public List<Contents> readContentsFacade(ReadRequest readRequest) {
		return contentsDataService.readContents(readRequest);
	}

	@Override
	public void updateContentsFacade(UpdateContentsRequest updateContentsRequest, String id) {
		contentsDataService.updateContents(updateContentsRequest, id);
	}

	@Override
	public void deleteContentsFacade(List<String> ids) {
		contentsDataService.deleteContents(ids);
	}

}
