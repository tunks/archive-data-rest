/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.service;

import com.att.archive.restful.model.ArchiveDocument;
import com.att.archive.restful.query.QueryHandler;
import com.att.archive.restful.query.SearchQuery;
import com.att.archive.restful.util.IArchiver;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.att.archive.restful.repositories.solr.DocumentRepository;
import com.att.archive.restful.repositories.CustomBaseRepository;

/**
 * Solr DocumentArchiveService class -- concrete implementation to the archive solr documents 
 * @author ebrimatunkara
 */
@Service("documentArchiveService")
 public class DocumentArchiveService extends ServiceBase<ArchiveDocument,String>{  
    @Resource
    private DocumentRepository  documentRepository;

    @Override
    public ArchiveDocument save(ArchiveDocument object, IArchiver archiver) {
        throw new UnsupportedOperationException("Operation not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomBaseRepository getRepository() {
       return documentRepository;
    }

    @Override
    public Page<ArchiveDocument> search(QueryHandler handler, SearchQuery query) {
         return documentRepository.search(handler, query);
    }
}
