package com.att.archive.restful.controller;

import com.att.archive.restful.query.QueryHandler;
import com.att.archive.restful.query.SearchQuery;
import com.att.archive.restful.service.ServiceBase;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ControllerBase abstract class 
 * @author ebrimatunkara
 * @param <T>
 */
public abstract class ControllerBase<T> {
    /**
     * Resource service instance
     * @return 
     **/
    protected abstract ServiceBase getService(); 
    /**
     * Resource query handler
     * @return 
     **/
    protected abstract QueryHandler getQueryHandler();
    /**
     * Request method to query and return resources
     * @param query
     * @return 
     **/
    protected Page<T> get(SearchQuery query){
       return getService().search(getQueryHandler(), query);
    }
    /**
     * Request method to find and return a resource by its id
     * @param id
     * @return 
     **/
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public T find(@PathVariable String id){
       return (T) getService().find(id);
    }
    /**
     * Request method to delete all resources
     **/
    @RequestMapping(method=RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(){
        getService().deleteAll();
    }
    /**
     * Request method to delete a resource by its id
     * @param id
     **/
    @RequestMapping( value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String id){
        getService().delete(id);
    }
    /**
     * Request method to create resource  
     * @param object
     **/
    public abstract void create(T object);
    /**
     * Request method to update resource
     * @param object
     **/
    public abstract void update(T object);
}
