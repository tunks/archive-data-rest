package com.att.archive.restful.message;

import com.att.archive.restful.controller.ArchiveRequest;
import com.att.archive.restful.service.ArchiveService;
import com.att.archive.restful.util.DataArchiver;
import com.att.archive.restful.util.DataHelper;
import com.att.archive.restful.util.IArchiver;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Message subscriber implementation
 * @author ebrima
 */

public class ArchiveMessageDelegate  implements MessageDelegate{
    @Autowired
    private ArchiveService archiveService;
    @Autowired
    private IArchiver archiver;
    
    @Override
    public void handleMessage(String message) {
        saveArchive((String)message);
    }

    @Override
    public void handleMessage(Map message) {
        throw new UnsupportedOperationException("Not supported yet.2");
    }

    @Override
    public void handleMessage(byte[] message) {
        throw new UnsupportedOperationException("Not supported yet.3");
    }

    @Override
    public void handleMessage(Serializable message) {
        saveArchive((String) message);
        System.out.println("save turf message received 4: "+message);
    }

    @Override
    public void handleMessage(Serializable message, String channel) {
        saveArchive((String)message);
        System.out.println("save turf save message received 5;");
    }   
    //save archive
    private void saveArchive(String message){
       ArchiveRequest request = DataHelper.jsonToObject(message,ArchiveRequest.class);
       archiveService.save(request, archiver);

    }
} 
