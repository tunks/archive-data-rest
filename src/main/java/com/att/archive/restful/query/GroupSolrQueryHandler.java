/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.query;

import java.util.Iterator;
import java.util.Set;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleField;
import org.springframework.data.solr.core.query.SimpleQuery;

/**
 *
 * @author ebrimatunkara
 */
public class GroupSolrQueryHandler extends SolrQueryHandler {

    @Override
    public boolean isValidQuery(SearchQuery query) {
         return !query.getGroup().isEmpty();
    }

    @Override
    public Query createQueryCriteria(SearchQuery query) {
        return createGroupOptions(query.getGroup());
    }
    
     private Query createGroupOptions(Set<String> group) {
            Query qCriteria = new SimpleQuery();
            Iterator<String> itr = group.iterator();
            while(itr.hasNext()){
               qCriteria.addGroupByField( new SimpleField(itr.next()));
            }
            return qCriteria;
     }
    
}
