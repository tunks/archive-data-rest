package com.att.archive.restful.service;

import com.att.archive.restful.model.ArchiveEntity;
import com.att.archive.restful.query.QueryHandler;
import com.att.archive.restful.query.SearchQuery;
import com.att.archive.restful.util.IArchiver;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.att.archive.restful.repositories.mongo.ArchiveRepository;
import com.att.archive.restful.repositories.CustomBaseRepository;

/**
 * ArchiveService class -- concrete implementation to manage the ArchiveEntitiy models
 * @author ebrima
 */
@Service("archiveService")
public class ArchiveService extends ServiceBase<ArchiveEntity,String>{
    //@Resource
   // private ArchiveRepository<ArchiveEntity,String> archiveRepository;
    
    @Override
    public ArchiveEntity save(ArchiveEntity object, IArchiver archiver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomBaseRepository getRepository() {
        return null ;//archiveRepository;
    }

    @Override
    public Page<ArchiveEntity> search(QueryHandler handler, SearchQuery query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
