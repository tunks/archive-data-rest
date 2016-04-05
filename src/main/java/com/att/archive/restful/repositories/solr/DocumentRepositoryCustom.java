/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.repositories.solr;

import java.io.Serializable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.solr.repository.SolrCrudRepository;
import com.att.archive.restful.repositories.CustomBaseRepository;

/**
 *
 * @author ebrimatunkara
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface DocumentRepositoryCustom<T, ID extends Serializable> 
        extends  SolrCrudRepository<T, ID>, CustomBaseRepository<T,ID> {
    
}
