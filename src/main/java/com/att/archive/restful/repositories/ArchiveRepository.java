package com.att.archive.restful.repositories;

import com.att.archive.restful.model.Archive;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * Archive repository interface
 * @author ebrima
 */

public interface ArchiveRepository extends SolrCrudRepository<Archive, String> {
    public List<Archive> findByType(String name);
    public List<Archive> findByTypeAndName(String type , String name );
    public List<Archive> findByComposites(Map composites);
    public List<Archive> findByCreatedOnBetweenAndType(Date from, Date to, String type);
    public List<Archive> findByCreatedOnBetweenAndTypeAndCompositesIn(Date from, Date to, String type, Set<Map<String,Object>>  composites);
    //@Query(value = "{ 'createdOn' : {$gte : ?0, $lte: ?1 }, 'type': ?0, 'name': ?0}")
    //public List<Archive> findByCreatedOnBetweenAndTypeAndNameQuery(Date from, Date to, String type, String Name);
    public List<Archive> findByCreatedOnBetweenAndTypeAndName(Date from, Date to, String type, String Name);
    public List<Archive> findByCreatedOnBetweenAndTypeAndNameAndCompositesIn(Date from, Date to, String type, String Name,  Set<Map<String, Object>>  composites);
    public List<Archive> findByCreatedOnAndType(Date date, String type);

    public Page<Archive> findByComposites(Map composite, Pageable page);

    public Page<Archive> findByCreatedOnBetweenAndTypeAndCompositesIn(Date date, Date endDate, String type, Set<Map<String, Object>> composite, Pageable page);

    public Page<Archive> findByTypeAndName(String type, String name, Pageable page);

    public Page<Archive> findByCreatedOnAndType(Date date, String type, Pageable page);

    public Page<Archive> findByCreatedOnBetweenAndType(Date date, Date endDate, String type, Pageable page);

    public Page<Archive> findByCreatedOnBetweenAndTypeAndName(Date date, Date endDate, String type, String name, Pageable page);

    public Page<Archive> findByCreatedOnBetweenAndTypeAndNameAndCompositesIn(Date date, Date endDate, String type, String name, Set<Map<String,Object>> composite, Pageable page);
}

