package com.att.archive.restful.service;

import com.att.archive.restful.controller.ArchiveRequest;
import com.att.archive.restful.model.Archive;
import com.att.archive.restful.repositories.ArchiveRepository;
import com.att.archive.restful.util.DateDeserializer;
import com.att.archive.restful.util.IArchiver;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Archive service
 * @author ebrima
 */
public class ArchiveService implements IArchiveService<ArchiveRequest>{
    @Autowired
    private ArchiveRepository archiveRepository;
    /**
     * list of all archives
     * @return 
     */
    
    @Override
    public List<Archive> findAll(){
     return  (List<Archive>) archiveRepository.findAll();
    }
    
    @Override
    public List<Archive> findAll(Map composite){
     return  archiveRepository.findByComposites(composite);
    }
    
    @Override
    public List<Archive> findAll(Date date, Date endDate, String type, Set<Map<String, Object>> composite){
     return  archiveRepository.findByCreatedOnBetweenAndTypeAndCompositesIn(date, endDate, type,composite);
    }
    
    @Override
    public Archive find(String id){
      return archiveRepository.findOne(id);
    }
    
    public Archive save(Archive archive){
      return archiveRepository.save(archive);
    }
    
    public void deleteAll(){
      archiveRepository.deleteAll();
    }

    @Override
    public Archive save(ArchiveRequest request, IArchiver archiver) {
      try {
          Archive archive = new Archive(); 
          archive.setName(request.getName());
          archive.setType(request.getDataType());
          //parse the date from string to date type
          Date date = DateDeserializer.deserialize(request.getDate());    
          archive.setCreatedOn(date);
          archive.addComposites(request.getComposites());
          archiver.compress(request.getContent(), archive);
          //save archive
          return save(archive);
       } catch (IOException | ParseException ex) {
          Logger.getLogger(ArchiveService.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    }

    @Override
    public List<Archive> findArchives(String type, String name) {
      return archiveRepository.findByTypeAndName(type, name);
    }
    
    @Override
    public List<Archive> findArchives(Date date, String type) {
        return archiveRepository.findByCreatedOnAndType(date,type);
    }
    
    @Override
    public List<Archive> findArchives(Date date,  Date endDate, String type) {      
        return archiveRepository.findByCreatedOnBetweenAndType(date, endDate, type);
    }
    
    @Override
    public List<Archive> findArchives(Date date, Date endDate, String type, String name) {
        return archiveRepository.findByCreatedOnBetweenAndTypeAndName(date, endDate, type, name);
    }

    @Override
    public List<Archive> findAll(Date date, Date endDate, String type, String name, Set<Map<String, Object>>  composite) {
        return archiveRepository.findByCreatedOnBetweenAndTypeAndNameAndCompositesIn(date, endDate, type, name, composite);
    }

    @Override
    public Page<Archive> findAll(Map composite, Pageable page) {
       return  archiveRepository.findByComposites(composite,page);
    }

    @Override
    public Page<Archive> findArchives(Date date, String type, Pageable page) {
        return archiveRepository.findByCreatedOnAndType(date,type,page);
    }

    @Override
    public Page<Archive> findArchives(String type, String name, Pageable page) {
        return archiveRepository.findByTypeAndName(type, name, page);
    }

    @Override
    public Page<Archive> findArchives(Date date, Date endDate, String type, Pageable page) {
        return archiveRepository.findByCreatedOnBetweenAndType(date, endDate, type,page);
    }

    @Override
    public Page<Archive> findArchives(Date date, Date endDate, String type, String name, Pageable page) {
        return archiveRepository.findByCreatedOnBetweenAndTypeAndName(date, endDate, type, name,page);
    }

    @Override
    public Page<Archive> findAll(Date date, Date endDate, String type, Set<Map<String, Object>> composite, Pageable page) {
        return  archiveRepository.findByCreatedOnBetweenAndTypeAndCompositesIn(date, endDate, type,composite,page);
    }

    @Override
    public Page<Archive> findAll(Date date, Date endDate, String type, String name, Set<Map<String, Object>> composite, Pageable page) {
        return archiveRepository.findByCreatedOnBetweenAndTypeAndNameAndCompositesIn(date, endDate, type, name, composite,page);
    }

    @Override
    public Page<Archive> findAll(Date date, String type, Set<Map<String, Object>> composite, Pageable page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<Archive> findAll(Date date, String type, String name, Set<Map<String, Object>> composite, Pageable page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
