/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.repositories.mongo;

import java.io.Serializable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.att.archive.restful.repositories.CustomBaseRepository;

/**
 *
 * @author ebrimatunkara
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface ArchiveRepository<T, ID extends Serializable> 
       extends CustomBaseRepository<T,ID>, MongoRepository<T,ID> {
         
}
