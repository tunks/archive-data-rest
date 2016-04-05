package com.att.archive.restful.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.data.domain.Pageable;

/** 
  Archive request class
**/
public class SearchQuery {
    private Map<String,String> query;
    private Set<String> group;
    private Map<String,String> range;
    private Map<String,String> sort;
    private Pageable page;
    private String date;
    private String endDate;
    
    public SearchQuery() {
      query = new HashMap<>();
      range = new HashMap<>();
      group = new HashSet<>();
    }

    public SearchQuery(Map<String, String> query,
                       Map<String, String> range, 
                       Set<String> group, 
                       Pageable page) {
        this.query = query;
        this.range = range;
        this.group = group;
        this.page = page;
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

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }   

    public Map<String, String> getQuery() {
        return query;
    }

    public void setQuery(Map<String, String> query) {
        this.query = query;
    }

    public Map<String, String> getRange() {
        return range;
    }

    public void setRange(Map<String, String> range) {
        this.range = range;
    }

    public Map<String, String> getSort() {
        return sort;
    }

    public void setSort(Map<String, String> sort) {
        this.sort = sort;
    }

    public Set<String> getGroup() {
        return group;
    }

    public void setGroup(Set<String> group) {
        this.group = group;
    }

    public Pageable getPage() {
        return page;
    }

    public void setPage(Pageable page) {
        this.page = page;
    }
    
}
