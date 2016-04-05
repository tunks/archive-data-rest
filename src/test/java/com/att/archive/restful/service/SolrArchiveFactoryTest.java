///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.att.archive.restful.service;
//
//import com.att.archive.restful.controller.ArchiveRequest;
//import com.att.archive.restful.model.DocumentArchive;
//import com.att.archive.restful.util.IArchiver;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// *
// * @author ebrimatunkara
// */
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:test-spring-config.xml"})
//public class SolrArchiveFactoryTest {
//    @Autowired
//    private ArchiveFactory solrArchiveFactory;
//    String name = "TICKET_TYPE";
//    String dataType = "bucket";
//    String date = "2015-10-25T19:08:56Z";
//    String endDate = "2015-10-30T19:08:56Z";
//    final String content =  "[{ \"name\": \"active\", \"type\": \"TICKET_TYPE\", \"count\" : 100},{ \"name\": \"active\", \"type\": \"TICKET_TYPE\", \"count\" : 100},{ \"name\": \"active\", \"type\": \"TICKET_TYPE\", \"count\" : 100},{ \"name\": \"active\", \"type\": \"TICKET_TYPE\", \"count\" : 100},{ \"name\": \"active\", \"type\": \"TICKET_TYPE\", \"count\" : 100},{ \"name\": \"active\", \"type\": \"TICKET_TYPE\", \"count\" : 100}]";
//    
//    public SolrArchiveFactoryTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of createObject method, of class SolrArchiveFactory.
//     */
//    @Test
//    public void testCreateObject() throws Exception {
//        System.out.println("createObject");
//        List<DocumentArchive> archives = null;
//        String dataType = "";
//        IArchiver archiver = null;  
//        List expResult = null;
//        List result =solrArchiveFactory.createObject(archives, dataType, archiver);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createArchives method, of class SolrArchiveFactory.
//     */
//    @Test
//    public void testCreateArchives() throws Exception {
//        System.out.println("createArchives");
//        ArchiveRequest request = new ArchiveRequest(name, dataType,date,endDate);
//        request.setContent(content);   
//        int expectedSize = 6;
//        List<DocumentArchive> result =solrArchiveFactory.createArchives(request);
//        assertSame("solr archive document list is 6", expectedSize, result.size());
//    }
//
//    /**
//     * Test of findArchives method, of class SolrArchiveFactory.
//     */
//    @Test
//    public void testFindArchives() {
//        System.out.println("findArchives");
//        IArchiveService service = null;
//        ArchiveRequest requests = null;
//        Page<DocumentArchive> expResult = null;
//        Page<DocumentArchive> result =solrArchiveFactory.findArchives(service, requests);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findArchiveObjects method, of class SolrArchiveFactory.
//     */
//    @Test
//    public void testFindArchiveObjects() throws Exception {
//        System.out.println("findArchiveObjects");
//        Page<DocumentArchive> archives = null;
//        IArchiver archiver = null;     
//        Page<DocumentArchive> expResult = null;
//        Page<DocumentArchive> result =solrArchiveFactory.findArchiveObjects(archives, archiver);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
