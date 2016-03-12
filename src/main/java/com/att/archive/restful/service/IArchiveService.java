package com.att.archive.restful.service;

import com.att.archive.restful.model.Archive;
import com.att.archive.restful.util.IArchiver;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Archive service interface
 * @author ebrima
 * @param <T>
 */

public interface IArchiveService<T> {
    public Archive save(T input, IArchiver archiver);
    public List<Archive> findAll();
    public List<Archive> findAll(Map composite);
    public List<Archive> findAll(Date date, Date endDate, String type, Set<Map<String, Object>>  composite);
    public List<Archive> findAll(Date date, Date endDate, String type, String name, Set<Map<String, Object>>  composite);
    public Archive find(String id);
    public List<Archive> findArchives(String type, String name);
    public List<Archive> findArchives(Date date, String type);
    public List<Archive> findArchives(Date date,  Date endDate, String type);
    public List<Archive> findArchives(Date date, Date endDate, String type, String name) ;
    public Page<Archive> findAll(Map composite, Pageable page);
    public Page<Archive> findArchives(Date date, String type,  Pageable page);
    public Page<Archive> findArchives(String type, String name, Pageable page);
    public Page<Archive> findArchives(Date date,  Date endDate, String type,  Pageable page);
    public Page<Archive> findArchives(Date date, Date endDate, String type, String name,  Pageable page);
    public Page<Archive> findAll(Date date, Date endDate, String type, Set<Map<String, Object>>  composite, Pageable page);
    public Page<Archive> findAll(Date date, String type, Set<Map<String, Object>>  composite, Pageable page);
    public Page<Archive> findAll(Date date, Date endDate, String type, String name, Set<Map<String, Object>>  composite, Pageable page);
    public Page<Archive> findAll(Date date, String type, String name, Set<Map<String, Object>>  composite, Pageable page);
 }
