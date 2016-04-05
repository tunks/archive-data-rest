package com.att.archive.restful.service;

import com.att.archive.restful.query.QueryHandler;
import com.att.archive.restful.query.SearchQuery;
import com.att.archive.restful.util.IArchiver;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.att.archive.restful.repositories.CustomBaseRepository;

/**
 * Archive service abstract class
 * @author ebrima
 * @param <T>
 * @param <ID>
 */
public abstract class  ServiceBase <T,ID extends Serializable> implements CrudService<T,ID>{
    
    public abstract CustomBaseRepository<T,ID> getRepository();
    
    @Override
    public void delete(ID id) {
        getRepository().delete(id);
    }

    @Override
    public void delete(List<ID> ids) {
        for (ID id : ids) {
            delete(id);
        }
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }

    @Override
    public T save(T object) {
        return (T) getRepository().save(object);
    }

    @Override
    public List<T> saveAll(List<T> objects) {
       return (List<T>) getRepository().save(objects);
    }

    @Override
    public T find(ID id) {
       return null;// return getRepository().findById(id);
    }

    @Override
    public List<T> find(List<ID> ids) {
       return (List<T>) getRepository().findAll(ids);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) getRepository().findAll();
    }
    
    public Page<T> findAll(Pageable page){
        return getRepository().findAll(page);
    }
    
    public abstract T save(T object, IArchiver archiver);
    public abstract Page<T> search(QueryHandler handler, SearchQuery query);
 }
