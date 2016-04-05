/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.repositories.mongo;

import com.att.archive.restful.model.ArchiveEntity;
import java.io.Serializable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 *  CustomMongoRepositoryFactoryBean -- instantiates the ArchiveRepositoryImpl class
 * @author ebrimatunkara
 * @param <T>
 * @param <S>
 * @param <ID>
 */
public class CustomMongoRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable> extends MongoRepositoryFactoryBean<T,S,ID>{

    @Override
    protected RepositoryFactorySupport getFactoryInstance(MongoOperations operations) {
        return  new CustomMongoRepositoryFactory(operations);
    }
   
    
    private static class CustomMongoRepositoryFactory extends MongoRepositoryFactory{
        private final MongoOperations mongoOperations;
        public CustomMongoRepositoryFactory(MongoOperations mongoOperations) {
            super(mongoOperations);
            this.mongoOperations = mongoOperations;
        }

        @Override
        protected Object getTargetRepository(RepositoryInformation information) {
            MongoEntityInformation mongoMeta = getEntityInformation(ArchiveEntity.class);
            return new ArchiveRepositoryImpl(mongoMeta,mongoOperations);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return ArchiveRepository.class;
        }
    }
}
