package com.att.archive.restful.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.solr.core.convert.CustomConversions;
import org.springframework.data.solr.core.convert.MappingSolrConverter;
import org.springframework.data.solr.core.convert.SolrConverter;
import org.springframework.data.solr.core.mapping.SimpleSolrMappingContext;

/**
 * Custom Solr Converter Factory Bean
 * @author ebrimatunkara
 */
public class SolrCustomConverter implements FactoryBean< SolrConverter>{
    private SolrConverter mappingSolrConverter() {
        final List<Object> converters = new ArrayList();
        final Converter customConverter = SolrDocumentToContentConverter.INSTANCE;
        final MappingContext  mappingContext =new SimpleSolrMappingContext();
        final MappingSolrConverter solrConverter = new MappingSolrConverter(mappingContext);
        converters.add(customConverter);
        solrConverter.setCustomConversions(new CustomConversions(converters));
        solrConverter.getConversionService().addConverter(customConverter);
        return solrConverter;
    }

    @Override
    public SolrConverter getObject() throws Exception {
      return mappingSolrConverter();
    }

    @Override
    public Class<?> getObjectType() {
      return SolrConverter.class; 
    }

    @Override
    public boolean isSingleton() {
         return true;
    }
}
