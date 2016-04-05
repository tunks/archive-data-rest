/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.repositories.support;

import com.att.archive.restful.repositories.CustomBaseRepository;
import com.att.archive.restful.repositories.solr.DocumentRepositoryImpl;
import java.io.Serializable;
import org.apache.solr.client.solrj.SolrServer;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.repository.support.SolrRepositoryFactory;
import org.springframework.data.solr.repository.support.SolrRepositoryFactoryBean;
import com.att.archive.restful.repositories.solr.DocumentRepositoryCustom;

/**
 * CustomSolrRepositoryFactoryBean -- instantiates  CustomRepositoryImp class
 * @author ebrimatunkara
 */
public class CustomSolrRepositoryFactoryBean  extends SolrRepositoryFactoryBean {
    @Override
    protected RepositoryFactorySupport doCreateRepositoryFactory() {
        return new CustomSolrRepositoryFactory(getSolrOperations());
    }

    private static class CustomSolrRepositoryFactory<T, ID extends Serializable> extends SolrRepositoryFactory {
        private SolrOperations solrOperations;
        
        public CustomSolrRepositoryFactory(SolrServer solrServer) {
            super(solrServer);
        }

        public CustomSolrRepositoryFactory(SolrOperations solrOperations) {
            super(solrOperations);
            this.solrOperations = solrOperations;
        }

       @Override
        protected Object getTargetRepository(RepositoryInformation metadata) {
            return new DocumentRepositoryImpl<>(solrOperations, (Class<T>) metadata.getDomainType());
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return DocumentRepositoryCustom.class;             
        }            
    }
}
