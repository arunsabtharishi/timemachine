package com.dragonfly.timemachine.service;

import com.dragonfly.timemachine.contents.InsertContentsRequest;
import com.dragonfly.timemachine.contents.UpdateContentsRequest;

public interface ContentsDataService {
    void insertContents(InsertContentsRequest insertContentsRequest);

    void updateContents(UpdateContentsRequest updatedContents, String id);
}
