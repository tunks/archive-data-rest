/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.query;

import org.springframework.beans.factory.FactoryBean;

/**
 * TODO 
 * @author ebrimatunkara
 */
public class SolrQueryFactoryBean implements FactoryBean<SolrQueryHandler>{

    @Override
    public SolrQueryHandler getObject() throws Exception {
       SolrQueryHandler simpleHandler =  new SimpleSolrQueryHandler();
       SolrQueryHandler rangeHandler = new RangeSolrQueryHandler();
       SolrQueryHandler groupHandler = new GroupSolrQueryHandler();
       simpleHandler.setNextHandler(rangeHandler);
       rangeHandler.setNextHandler(groupHandler);
       return simpleHandler;
    }

    @Override
    public Class<?> getObjectType() {
      return SolrQueryHandler.class;
    }

    @Override
    public boolean isSingleton() {
       return false;
    } 
}
