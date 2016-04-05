/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.service;

import com.att.archive.restful.model.ArchiveDocument;
import com.att.archive.restful.query.QueryHandler;
import com.att.archive.restful.query.SearchQuery;
import com.att.archive.restful.query.SolrQueryHandler;
import com.att.archive.restful.util.DateDeserializer;
import com.att.archive.restful.util.DateUtil;
import com.att.archive.restful.util.IArchiver;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.att.archive.restful.repositories.CustomBaseRepository;

/**
 *
 * @author ebrimatunkara
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@ActiveProfiles("dev")
public class DocumentArchiveServiceTest {
    @Autowired
    ServiceBase<ArchiveDocument,String> documentArchiveService;
   
    @Autowired
    private SolrQueryHandler solrQueryHanlder;
    
    SearchQuery query;
    final String name = "TICKET_TYPE";
    final String type = "bucket";
    final String date = "2015-11-20T15:33:01Z";
    final String rsLine = "ANIRA";
    
    public DocumentArchiveServiceTest() {}
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        query = new SearchQuery();
        Map q = new HashMap();
        q.put("name", name);
        q.put("data_type", type);
        // q.put("rsLine_t", rsLine);

        Set<String> group = new HashSet();
        group.add("rsLine_t");

        Map range = new HashMap();
        range.put("created_date", "2015-11-01T12:23:01ZTO2015-11-30T12:23:01Z");

        Map sort = new HashMap();
        sort.put("created_date", "DESC");

        query.setQuery(q);
        query.setGroup(group);
        query.setRange(range);
        query.setSort(sort);
    }
    
    @After
    public void tearDown() {}

    /**
     * Test of save method with Archiver instance, of class DocumentArchiveService.
     */
    @Test
    public void testSaveWithArchiver(){
        System.out.println("save with archiver");
        ArchiveDocument object = new ArchiveDocument();
        IArchiver archiver = null;
        ArchiveDocument result = null;
        try {
           result = documentArchiveService.save(object, archiver);
        }catch( Exception ex){
           System.out.println(ex.getMessage());
        }
        assertNull(result);
    }
    
     /**
     * Test of save method,, of class DocumentArchiveService.
     * @throws java.text.ParseException
     */
    @Test
    public void testSave() throws ParseException {
        System.out.println("save document");
        Date createdOn = DateUtil.parseDate(date);
        ArchiveDocument object = new ArchiveDocument(type,name,createdOn);
        object.getTextContent().put("rsLine", "ANIRA");
        ArchiveDocument result = documentArchiveService.save(object);
        assertNotNull(result);
    }
    
    @Test
    public void testDelete(){
      String id = "390480cd-08bb-432e-954f-0cf3563d3d56";
      documentArchiveService.delete(id);
      ArchiveDocument result = documentArchiveService.find(id);
      assertNull(result);
    }

    /**
     * Test of getRepository method, of class DocumentArchiveService.
     */
    @Test
    public void testGetRepository() {
        System.out.println("getRepository");
        CustomBaseRepository result = documentArchiveService.getRepository();
        assertNotNull(result);
    }

    /**
     * Test of search method, of class DocumentArchiveService.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        Page<ArchiveDocument> result = documentArchiveService.search(solrQueryHanlder, query);
        assertTrue(result.getContent().size() > 0);
    }
    
}
