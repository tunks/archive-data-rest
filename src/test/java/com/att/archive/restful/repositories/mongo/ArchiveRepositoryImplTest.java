/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.repositories.mongo;

import com.att.archive.restful.model.ArchiveEntity;
import com.att.archive.restful.query.QueryHandler;
import com.att.archive.restful.query.SearchQuery;
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

/**
 *
 * @author ebrimatunkara
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@ActiveProfiles("dev")
public class ArchiveRepositoryImplTest {
    String content;
    String name;
    String dataType;
    String createdOn;
    
    @Autowired
    private ArchiveRepository<ArchiveEntity,String> archiveRepository;
    
    public ArchiveRepositoryImplTest() {}
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Before
    public void setUp() {
        name = "TICKET_TYPE";
        dataType = "bucket";
        createdOn = "2016-03-23T10:25:01Z";
        content = "[{ \"name\": \"active\", \"type\": \""+dataType+"\", \"count\" : 100, \"rsLine\": \"ALL\"},"
                + " { \"name\": \"active\", \"type\": \""+dataType+"\", \"count\" : 100, \"rsLine\": \"AVPN\"},"
                + " { \"name\": \"active\", \"type\":\""+dataType+"\", \"count\" : 100, \"rsLine\": \"ANIRA\"},"
                + " { \"name\": \"active\", \"type\": \""+dataType+"\", \"count\" : 100, \"rsLine\": \"WAN\"},"
                + " { \"name\": \"active\", \"type\": \""+dataType+"\", \"count\" : 100, \"rsLine\": \"LAN\"},"
                + " { \"name\": \"active\", \"type\":\""+dataType+"\", \"count\" : 100, \"rsLine\": \"WEB HOSTING\"}]";    
    }
    
    @After
    public void tearDown() {
    
    }
    
    /**
     * Test of save method 
     **/
    @Test
    public void testSave(){
       ArchiveEntity entity = new ArchiveEntity(dataType,name,createdOn, content);
       ArchiveEntity result = archiveRepository.save(entity);
       assertEquals(entity, result);
    }

    /**
     * Test of search method, of class ArchiveRepositoryImpl.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        QueryHandler handler = null;
        SearchQuery query = null;
        ArchiveRepositoryImpl instance = null;
        Page<ArchiveEntity> expResult = null;
        Page<ArchiveEntity> result = instance.search(handler, query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testDeleteAll(){
        archiveRepository.deleteAll();
        int expected  = 0 ;
        Long result = archiveRepository.count();
        assertEquals(result.intValue(), expected);
    }
   
}
