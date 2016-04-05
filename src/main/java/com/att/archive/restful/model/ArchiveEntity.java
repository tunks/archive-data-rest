package com.att.archive.restful.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * ArchiveEntity model 
 * This class model will be persisted on the mongo database
 **/
@Configurable
@Document
public class ArchiveEntity implements Serializable{
    @Id
    private String id;    
    private String dataType;
    private String dataFormat;
    private String createdOn;
    private String name;
    private Set<Map<String,Object>> composites;
    private String content;

    public ArchiveEntity() {
        init();
    }
    
    public ArchiveEntity(String dataType, String name, String createdOn) {
        this.dataType = dataType;
        this.name = name;
        this.createdOn = createdOn;
        init();
    }

    public ArchiveEntity(String dataType,String name, String createdOn,  String content) {
        this.dataType = dataType;
        this.name = name;
        this.createdOn = createdOn;
        this.content = content;
        init();
    }
    
    private void init(){
        composites = new HashSet();
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    public Set<Map<String, Object>> getComposites() {
        return composites;
    }

    public void setComposites(Set<Map<String, Object>> composites) {
        this.composites = composites;
    }
    
    public void addComposite(Map<String, Object> composite){
       this.composites.add(composite);
    }
    
    public void addComposites(Set<Map<String, Object>> objects){
       this.composites.addAll(objects);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
