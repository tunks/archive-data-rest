package com.att.archive.restful.listener;

import com.att.archive.restful.model.ArchiveEntity;
import com.att.archive.restful.model.ArchiveDocument;
import com.att.archive.restful.util.ArchiveFactory;
import com.att.archive.restful.service.ServiceBase;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;

/**
 *  ArchiveEnityAfterSave event listener
 * @author ebrimatunkara
 */
public class ArchiveAfterSaveListener extends AbstractMongoEventListener<ArchiveEntity> {
    @Autowired
    private ServiceBase documentArchiveService;
    @Autowired
    private ArchiveFactory solrArchiveFactory;

    @Override
    public void onAfterSave(AfterSaveEvent<ArchiveEntity> event) {
        try {
            List<ArchiveDocument> documents = solrArchiveFactory.create(event.getSource());
            documentArchiveService.saveAll(documents);
        } catch (IOException ex) {
            Logger.getLogger(ArchiveAfterSaveListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.onAfterSave(event);
    }   
}
