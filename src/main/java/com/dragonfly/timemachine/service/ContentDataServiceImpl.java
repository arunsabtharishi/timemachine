package com.dragonfly.timemachine.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dragonfly.timemachine.contents.InsertContentsRequest;
import com.dragonfly.timemachine.repository.ContentsJpaRepository;

public class ContentDataServiceImpl implements ContentsDataService {
	
	@Autowired
	private ContentsJpaRepository contentsRepository;
	
	@Override
	public void enterContents(InsertContentsRequest insertContentsRequest) {
		
	}
}
