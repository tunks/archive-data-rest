package com.att.archive.restful.controller;

import com.att.archive.restful.model.Archive;
import com.att.archive.restful.model.BaseArchive;
import com.att.archive.restful.service.ArchiveService;
import com.att.archive.restful.service.IArchiveFactory;
import com.att.archive.restful.util.DataHelper;
import com.att.archive.restful.util.IArchiver;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;     
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
  Archive rest controller
*/
@RestController
public class ArchiveController {
    @Autowired
    private ArchiveService archiveService;  
    @Autowired
    private IArchiveFactory archiveFactory;
    @Autowired
    private IArchiver archiver;
    
    /**
     * @param type
     * @param name
     * @param date
     * @param endDate
     * @param composites
     * @param page
     * @return , list of archives objects
     * @throws java.text.ParseException
     * @throws java.io.IOException
     */
    @RequestMapping(value="/att/archives", method=RequestMethod.GET)
    public Page<BaseArchive> getArchiveObjects(
            @RequestParam(value="dataType") String type, 
            @RequestParam(value="date") String date,
            @RequestParam(value="name", required=false) String name,
            @RequestParam(value="endDate") String endDate,
            @RequestParam(value="composites", required=false) String[] composites,
            Pageable page) throws ParseException, IOException
    {
        ArchiveRequest request  = new ArchiveRequest(name,type,date,endDate,DataHelper.toCompositeSet(composites),page);
        Page<Archive> archives = archiveFactory.createArchivesWithPage(archiveService, request);
        return archiveFactory.createObjectWithPage(archives, archiver);
    }

    @RequestMapping(value="/att/archives", method=RequestMethod.POST)
    @ResponseBody
    public void saveArchives(@RequestBody ArchiveRequest request) throws IOException{
        if(validateArchiveParams(request))
        {
           archiveService.save(request, archiver);
        }
    }
    
    @RequestMapping(value="/att/archives/{id}", method=RequestMethod.GET)
    public Archive getArchive(@PathVariable String id){
       return archiveService.find(id);
    } 
    /**
     * @return 
     **/
    @RequestMapping(value="/att/archives", method=RequestMethod.DELETE)
    public List<Archive> deleteAllArchives()   {
       return archiveService.findAll();
    }
    
    private boolean validateArchiveParams(ArchiveRequest request ){
      return (request.getContent() != null && request.getDataType() != null);
    }
}