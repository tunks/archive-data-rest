/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.repositories.solr;

import com.att.archive.restful.query.SearchQuery;
import com.att.archive.restful.query.QueryHandler;
import com.att.archive.restful.query.SolrQueryHandler;
import java.io.Serializable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SolrPageRequest;
import org.springframework.data.solr.repository.query.SolrEntityInformation;
import org.springframework.data.solr.repository.support.SimpleSolrRepository;

/**
 * Custom Repository concrete implementation Solr Document Repository
 * @author ebrimatunkara
 * @param <T>
 * @param <ID>
 */
public class DocumentRepositoryImpl<T, ID extends Serializable>
        extends SimpleSolrRepository<T,ID>
        implements DocumentRepositoryCustom<T,ID>{

    public DocumentRepositoryImpl() {
        super();
    }

    public DocumentRepositoryImpl(SolrOperations solrOperations) {
        super(solrOperations);
    }

    public DocumentRepositoryImpl(SolrOperations solrOperations, Class<T> entityClass) {
        super(solrOperations, entityClass);
    }

    public DocumentRepositoryImpl(SolrEntityInformation<T, ?> metadata, SolrOperations solrOperations) {
        super(metadata, solrOperations);
    }

    @Override
    public Page<T> search(QueryHandler handler, SearchQuery query) {
        if(handler instanceof SolrQueryHandler){
           Query qCriteria = ((SolrQueryHandler) handler).processQuery(query);
           return performQuery(qCriteria,query);         
        }
       return null;
    }
    
    private Page<T> performQuery(Query qCriteria, SearchQuery query){
       Pageable page = (query.getPage() == null)? new SolrPageRequest(0,20) : query.getPage();
       qCriteria.setPageRequest(page);
       if(!query.getGroup().isEmpty()) 
            return this.getSolrOperations().queryForGroupPage(qCriteria, getEntityClass());          
        else
            return this.getSolrOperations().queryForPage(qCriteria, getEntityClass());          
       }

//    @Override
//    public T findById(ID id) {
//       return this.getSolrOperations().getById(id, getEntityClass());
//    }
}
