package com.att.archive.restful.service;

import java.util.List;

/**
 * CrudService interface
 * @author ebrimatunkara
 * @param <T> , Entity class type
 * @param <ID>, Entity identity (id) data type
 */
public interface CrudService<T,ID> {
    /**
     * Delete model object by its id
     * @param id
     **/
    public void delete(ID id);
    /**
     * Delete list of domains by list of ids
     * @param ids
     **/
    public void delete(List<ID> ids);
    /**
     * Delete all domains
     **/
    public void deleteAll();
    /**
     * Save model object
     * @param object
     * @return , returns saved object
     **/
    public T save(T object);
    /**
     * Save list of model objects
     * @param objects
     * @return ,list of saved objects
     **/
    public List<T>saveAll(List<T> objects);
    /**
     * Find model object by ID 
     * @param id, model id
     * @return , returns model or null if not found
     **/
    public T find(ID id);
    /**
     * Find list of models objects by list of ID (ids)
     * @param ids, list of model object ids
     * @return , returns list of model objects found or turns empty if nothing is found
     **/
    public List<T> find(List<ID> ids);
    /**
     * Find list of all model objects 
     * @return , returns all model objects or empty if nothing is found
     **/
    public List<T> findAll();
}
