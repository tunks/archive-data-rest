package com.att.archive.restful.message;

import com.att.archive.restful.service.ServiceBase;
import com.att.archive.restful.util.IArchiver;
import java.io.Serializable;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Message subscriber implementation
 * @author ebrima
 */

public class ArchiveMessageDelegate  implements MessageDelegate{
    @Autowired
    private ServiceBase archiveService;
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
    //TODO
    private void saveArchive(String message){
       //ArchiveRequest request = DataHelper.jsonToObject(message,ArchiveRequest.class);
       //archiveService.save(request, archiver);

    }
} 
