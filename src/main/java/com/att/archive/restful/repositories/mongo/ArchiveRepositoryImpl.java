package com.att.archive.restful.repositories.mongo;

import com.att.archive.restful.model.ArchiveEntity;
import com.att.archive.restful.query.SearchQuery;
import com.att.archive.restful.query.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

/**
 * 
 * @author ebrimatunkara
 */
public class ArchiveRepositoryImpl extends SimpleMongoRepository<ArchiveEntity,String> 
                                 {
    public ArchiveRepositoryImpl(MongoEntityInformation metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
    }

   // @Override
    public Page<ArchiveEntity> search(QueryHandler handler, SearchQuery query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public ArchiveEntity findById(String id) {
//           return findOne(id);
//    }
}
