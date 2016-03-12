package com.att.archive.restful.service;

import com.att.archive.restful.controller.ArchiveRequest;
import com.att.archive.restful.model.Archive;
import com.att.archive.restful.model.BaseArchive;
import com.att.archive.restful.util.DataHelper;
import com.att.archive.restful.util.DateDeserializer;
import com.att.archive.restful.util.IArchiver;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

/**
 * Data archive factory class
 * @author ebrima
 */

public class DataArchiveFactory implements IArchiveFactory {
    @Override
    public Archive createNewArchive(String data) {
        return new Archive();
    }

    @Override
    public List<Archive> createArchives(IArchiveService service, ArchiveRequest request) {
        try {
            Date date = DateDeserializer.deserialize(request.getDate());
            Date endDate = DateDeserializer.deserialize(request.getEndDate());
            if (request.getComposites() != null) {
                return service.findAll(date,endDate, request.getDataType(), request.getName(), request.getComposites());
            }
            return service.findArchives(date, endDate,  request.getDataType(),  request.getName());

        } catch (ParseException ex) {
            Logger.getLogger(DataArchiveFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    /*Transform the archive into archive objects */
    @Override
    public List createObject(List<Archive> archives, String dataType, IArchiver archiver) throws IOException {
      return createArchiveObjects(archives,archiver);
    } 
   
    @Override
    public Page<Archive> createArchivesWithPage(IArchiveService service, ArchiveRequest request) {
        try {
            Date startDate = DateDeserializer.deserialize(request.getDate());
            Date endDate =  DateDeserializer.deserialize(request.getEndDate());
            //composite request parameter is available
            if(request.getComposites() != null && !request.getComposites().isEmpty()){
              return service.findAll(startDate, endDate, request.getDataType(), request.getName(),request.getComposites(),request.getPage());
            }
            //composite request parameter is not available  and name is available
            if(request.getName() != null){
               return service.findArchives(startDate, endDate, request.getDataType(), request.getName(),request.getPage());
            }
            //composite request parameter is not available and name is not available
            return service.findArchives(startDate, endDate, request.getDataType(),request.getPage());

        } catch (ParseException ex) {
            Logger.getLogger(DataArchiveFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Page<BaseArchive> createObjectWithPage(Page<Archive> archives, IArchiver archiver) throws IOException{
        List list = createArchiveObjects(archives.getContent(),archiver);
        return new PageImpl(list);
    }
    // transform archive to archive objects 
    private List createArchiveObjects(List<Archive> archives, IArchiver archiver) throws IOException{
        List list = new ArrayList();
        JsonElement json;
        String jsonString;
        BaseArchive archive;
        for (Archive a : archives) {
             jsonString = archiver.decompress(a);
             json = new JsonParser().parse(jsonString);
             archive = new BaseArchive();
             archive.setId(a.getId());
             archive.setName(a.getName());
             archive.setType(a.getType());
             archive.setCreatedOn(a.getCreatedOn());
             if(json.isJsonArray()){
                archive.setContent(DataHelper.toJsonObjectList(json.toString()));
             }
             else{
                List temp = new ArrayList();
                temp.add(DataHelper.jsonToObject(json.toString(),Map.class));
                archive.setContent(temp);
             }  
             list.add(archive);
        }
        return list;
    }
}
