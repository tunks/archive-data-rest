/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.repositories.solr;

import com.att.archive.restful.model.ArchiveDocument;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
/**
 * Document Custom repository interface
 * @author ebrimatunkara
 */
//@NoRepositoryBean
@Repository
public interface DocumentRepository extends DocumentRepositoryCustom<ArchiveDocument, String>{
}
