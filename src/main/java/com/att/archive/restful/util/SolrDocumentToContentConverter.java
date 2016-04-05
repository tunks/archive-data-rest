/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.util;

import com.att.archive.restful.model.ArchiveDocument;
import com.att.archive.restful.model.SearchableContent;
import java.util.Iterator;
import java.util.Map.Entry;
import org.apache.solr.common.SolrDocument;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.convert.ReadingConverter;

/**
 * Convert SolrDocument to Content
 * @author ebrimatunkara
 */
@ReadingConverter
public enum SolrDocumentToContentConverter implements Converter<SolrDocument,ArchiveDocument>{
    INSTANCE;
      
    @Override
    public ArchiveDocument convert(SolrDocument source) {
          final DefaultConversionService conversionService;
        Entry<String,Object> entry;
        Iterator<Entry<String,Object>> itr = source.entrySet().iterator();
        SearchableContent content = new ArchiveDocument();
        while(itr.hasNext()){
            entry = itr.next();
            content.put(entry.getKey(), entry.getValue());
        }
        return (ArchiveDocument) content;
    }
}
