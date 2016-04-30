package com.dragonfly.timemachine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dragonfly.timemachine.contents.DeleteContentsRequest;
import com.dragonfly.timemachine.contents.InsertContentsRequest;
import com.dragonfly.timemachine.contents.ReadRequest;
import com.dragonfly.timemachine.contents.UpdateContentsRequest;
import com.dragonfly.timemachine.domain.Contents;
import com.dragonfly.timemachine.service.ContentsDataService;

@Controller
public class ContentsController {


    @Autowired
    private ContentsDataService contentsDataService;

    @RequestMapping(value = "/createContents", method = RequestMethod.POST)
    @ResponseBody
    public void insertContents(@RequestBody InsertContentsRequest insertContentsRequest) {
        contentsDataService.createContents(insertContentsRequest);
    }
        
    @RequestMapping(value = "/readContents", method = RequestMethod.POST)
    @ResponseBody
    public List<Contents> readContents(@RequestBody ReadRequest readRequest) {
        return contentsDataService.readContents(readRequest);
    }

    @RequestMapping(value = "/updateContents/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateContents(@PathVariable String id, @RequestBody UpdateContentsRequest updateContentsRequest) {
        contentsDataService.updateContents(updateContentsRequest, id);
    }
    
    @RequestMapping(value = "/deleteContents", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteContents(@RequestBody DeleteContentsRequest deleteContentsRequest) {
        contentsDataService.deleteContents(deleteContentsRequest.getIds());
    }

}
