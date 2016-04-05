package com.att.archive.restful.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import org.springframework.data.annotation.Id;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Dynamic;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.HashMap;
/**
 * Document Archive model class
 * This class object will be indexed into the solr server
 * @author ebrima
 */
//@Configurable
@SolrDocument
public final class ArchiveDocument extends SearchableContent implements Serializable {
    /*
     * Solr Document Id 
     */
    @Id
    @Indexed
    @Field(ID_FIELD)
    private String id;
    /**
     * archive data type
     **/
    @Field(TYPE_FIELD)
    private String type;
    /**
     * archive name
     **/
    @Field(NAME_FIELD)
    private String name;
    /**
     * archive data created on
     **/
    @Field(DATE_FIELD)
    @DateTimeFormat( iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdOn;
    /**
     * archive dynamic string text field contents
     **/
    @Dynamic
    @Field("*" + TEXT_FIELD)
    private Map<String, String> textContent ;
    
    /**
     * archive dynamic numeric field contents
     **/
    @Dynamic
    @Field("*" + NUMERIC_FIELD)
    private Map<String,Double> numericContent;

    public ArchiveDocument(){
//       init();
    }
    
    public ArchiveDocument(String id, String type, String name, Date createdOn) {
        this(type,name,createdOn);
        this.id = id;
    }
    
    public ArchiveDocument(String type, String name, Date createdOn) {
        this.type = type;
        this.name = name;
        this.createdOn = createdOn;
        init();
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
     }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }
    
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
  
    public Map<String, String> getTextContent() {
        return textContent;
    }

    public void setTextContent(Map<String, String> textContent) {
        this.textContent = textContent;
    }

    public Map<String, Double> getNumericContent() {
        return numericContent;
    }

    public void setNumericContent(Map<String, Double> numericContent) {
        this.numericContent = numericContent;
    }
      
    private void init(){
      textContent = new HashMap();
      numericContent = new HashMap();
    }  
}
