package com.att.archive.restful.controller;

/* 
  Archive request class
*/
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.data.domain.Pageable;

public class ArchiveRequest {
    private String content;
    private String name;
    private String dataType;
    private String compressedType;
    private String date;
    private String endDate;
    private Set<Map<String,Object>> composites;
    private Pageable page;

    public ArchiveRequest() {
        composites =  new HashSet();
    }

    public ArchiveRequest(String name, String dataType, String date, String endDate, Set<Map<String, Object>>  composites) {
        this.name = name;
        this.dataType = dataType;
        this.date = date;
        this.endDate = endDate;
        this.composites = composites;
    }

    public ArchiveRequest(String name, String dataType, String date, String endDate, Set<Map<String, Object>>  composites,Pageable page) 
    {
        this.name = name;
        this.dataType = dataType;
        this.date = date;
        this.endDate = endDate;
        this.composites = composites;
        this.page = page;
    }
     public ArchiveRequest(String name, String dataType, String date, String endDate) {
        this.name = name;
        this.dataType = dataType;
        this.date = date;
        this.endDate = endDate;
    }
     
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompressedType() {
        return compressedType;
    }

    public void setCompressedType(String compressedType) {
        this.compressedType = compressedType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEndDate() {
        return endDate;
    }

    public Set<Map<String, Object>> getComposites() {
        return composites;
    }

    public void setComposites(Set<Map<String, Object>> composites) {
        this.composites = composites;
    }
    
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Pageable getPage() {
        return page;
    }

    public void setPage(Pageable page) {
        this.page = page;
    }
}
