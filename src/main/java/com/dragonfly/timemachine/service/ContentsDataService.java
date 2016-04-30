package com.dragonfly.timemachine.service;

import java.util.List;

import com.dragonfly.timemachine.contents.InsertContentsRequest;
import com.dragonfly.timemachine.contents.ReadRequest;
import com.dragonfly.timemachine.contents.UpdateContentsRequest;
import com.dragonfly.timemachine.domain.Contents;

public interface ContentsDataService {
    void createContents(InsertContentsRequest insertContentsRequest);
    
    List<Contents> readContents(ReadRequest readRequest);

    void updateContents(UpdateContentsRequest updatedContents, String id);
    
    void deleteContents(List<String> id);
}
