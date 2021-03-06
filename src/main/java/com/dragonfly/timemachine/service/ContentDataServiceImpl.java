package com.dragonfly.timemachine.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dragonfly.timemachine.contents.InsertContentsRequest;
import com.dragonfly.timemachine.contents.ReadRequest;
import com.dragonfly.timemachine.contents.UpdateContentsRequest;
import com.dragonfly.timemachine.domain.Contents;
import com.dragonfly.timemachine.repository.ContentsJpaRepository;

@Service
public class ContentDataServiceImpl implements ContentsDataService {

    @Autowired
    private ContentsJpaRepository contentsRepository;
    
    @Override
    public void createContents(InsertContentsRequest insertContentsRequest) {
        Contents contents = new Contents();

        String contentsFromRequest = insertContentsRequest.getContents();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        java.sql.Date contentDate = null;

        if(null == insertContentsRequest.getContentDate()) {
            contentDate = new java.sql.Date(System.currentTimeMillis());
        }
        else {
            try {
                contentDate  = (java.sql.Date) sdf.parse(insertContentsRequest.getContentDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        String userName = insertContentsRequest.getUserName();

        contents.setContent(contentsFromRequest);
        contents.setContentDate(contentDate);
        contents.setUserName(userName);

        contentsRepository.save(contents);
    }
    
    @Override
    public List<Contents> readContents(ReadRequest readRequest){
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	List<Contents> contents = null;
    	try {
    		Calendar c = Calendar.getInstance();
    		Date contentDate1 = formatter.parse(readRequest.getContentDate());
    		
    		c.setTime(contentDate1);
    		c.add(Calendar.DATE, 1);  // number of days to add
    		String date = formatter.format(c.getTime());
    		Date contentDate2 = formatter.parse(date);
			contents =  (List<Contents>)contentsRepository.findByContentDate
					(contentDate1, contentDate2, readRequest.getUserName());
		} catch (ParseException e) {		
			e.printStackTrace();
		}    	    	
    	return contents;
    }


    @Transactional
    @Override
    public void updateContents(UpdateContentsRequest updatedContents, String id) {
        String updateContent= updatedContents.getUpdatedContents();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date updateContentDate = null;
        try {
            updateContentDate = updatedContents.getUpdatedContentDate()!=null ? (java.sql.Date) sdf.parse(updatedContents.getUpdatedContentDate()) : null;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(null != updateContent || null != updateContentDate) {
            Contents contents = contentsRepository.findOne(id);
            updateContent = (updateContent==null) ? contents.getContent() : updateContent;
            contents.setContent(updateContent);
            updateContentDate = (updateContentDate==null) ? contents.getContentDate() : updateContentDate;
            contents.setContentDate(updateContentDate);
            contentsRepository.saveAndFlush(contents);
        }
    }

	@Override
	public void deleteContents(List<String> ids) {
		List<Contents> contents = (List<Contents>) contentsRepository.findAll(ids);
		contentsRepository.delete(contents);
	}
    
    
    
}