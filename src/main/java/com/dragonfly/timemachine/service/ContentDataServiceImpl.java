package com.dragonfly.timemachine.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragonfly.timemachine.contents.InsertContentsRequest;
import com.dragonfly.timemachine.domain.Contents;
import com.dragonfly.timemachine.repository.ContentsJpaRepository;

@Service
public class ContentDataServiceImpl implements ContentsDataService {
	
	@Autowired
	private ContentsJpaRepository contentsRepository;
	
	@Override
	public void insertContents(InsertContentsRequest insertContentsRequest) {
		Contents contents = new Contents();
		
		String contentsFromRequest = insertContentsRequest.getContents();	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
       
        java.sql.Date contentDate = null;
		
		if(null == insertContentsRequest.getContentDate()) {
			contentDate = new Date(System.currentTimeMillis());
		}
		else {
			try {
				contentDate  = (Date) sdf.parse(insertContentsRequest.getContentDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		contents.setContent(contentsFromRequest);
		contents.setContentDate(contentDate);
		contentsRepository.save(contents);
	}
}
