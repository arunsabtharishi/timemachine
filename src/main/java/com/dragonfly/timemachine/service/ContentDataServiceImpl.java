package com.dragonfly.timemachine.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.dragonfly.timemachine.contents.InsertContentsRequest;
import com.dragonfly.timemachine.domain.Contents;
import com.dragonfly.timemachine.repository.ContentsJpaRepository;

public class ContentDataServiceImpl implements ContentsDataService {
	
	@Autowired
	private ContentsJpaRepository contentsRepository;
	
	@Override
	public void insertContents(InsertContentsRequest insertContentsRequest) {
		Contents contents = new Contents();
		
		String contentsFromRequest = insertContentsRequest.getContents();
		Date contentDate = (null == insertContentsRequest.getContentDate()) ?
				new Date(System.currentTimeMillis()) : insertContentsRequest.getContentDate();
		contents.setContent(contentsFromRequest);
		contents.setContentDate(contentDate);
		contentsRepository.save(contents);
	}
}
