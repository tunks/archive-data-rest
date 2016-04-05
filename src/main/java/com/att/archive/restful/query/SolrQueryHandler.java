/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.query;

import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;

/**
 * @author ebrimatunkara
 */
 public abstract class SolrQueryHandler implements QueryHandler<Query>{
    private SolrQueryHandler nextHandler = null;

    public SolrQueryHandler() {}

    public SolrQueryHandler(SolrQueryHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public SolrQueryHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(SolrQueryHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public Query processQuery(SearchQuery query){  
      return createQuery(query);
    }
    
    protected Query createQuery(SearchQuery query) {
       Query qCriteria = createQueryCriteria(query);
       //create query criteria 
       if(isValidQuery(query)){
          qCriteria = createQueryCriteria(query); 
       }
       
       SolrQueryHandler handler = getNextHandler();
       if(handler != null){
          if( qCriteria == null){
              qCriteria = createQuery(query);
          }
          else{
              Query tempQuery = handler.createQuery(query);
              tempQuery.addCriteria(qCriteria.getCriteria());
              tempQuery.addSort(qCriteria.getSort());
              Criteria c;
              return tempQuery;    
          }
       } 
       return qCriteria;
    }

    public abstract boolean isValidQuery(SearchQuery query);
    public abstract Query createQueryCriteria(SearchQuery query);
}
