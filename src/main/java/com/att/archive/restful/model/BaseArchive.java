
package com.att.archive.restful.model;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Base Archive class
 * @author ebrima
 */
@Document
public class BaseArchive {
    @Id
    private String id;
    private String type;
    private String name;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    private Date createdOn;
    private List content;

    public BaseArchive() {}

    public BaseArchive(String id, String type, String name, Date createdOn) {
     this.id = id;
     this.type = type;
     this.name = name;
     this.createdOn = createdOn;
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

    public List getContent() {
        return content;
    }

    public void setContent(List content) {
        this.content = content;
    }
}
