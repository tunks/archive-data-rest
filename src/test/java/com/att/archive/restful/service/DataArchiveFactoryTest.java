//package com.att.archive.restful.service;
//
//import com.att.archive.restful.controller.ArchiveRequest;
//import com.att.archive.restful.model.Archive;
//import com.att.archive.restful.util.DataArchiver;
//import com.att.archive.restful.util.IArchiver;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// *
// * @author ebrima
// */
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:test-spring-config.xml"})
//public class DataArchiveFactoryTest {
//    @Autowired
//    ArchiveService archiveService; 
//    ArchiveFactory archiveFactory;
//    String name = "TICKET_TYPE";
//    String dataType = "bucket";
//    String date = "2015-10-25T19:08:56Z";
//    String endDate = "2015-10-30T19:08:56Z";
//    
//    public DataArchiveFactoryTest() {
//       archiveFactory = new DataArchiveFactory();
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
//     * Test of createNewArchive method, of class DataArchiveFactory.
//     */
////    @Test
////    public void testCreateNewArchive() {
////        System.out.println("createNewArchive");
////        String data = "";
////        Archive expResult = null;
////        Archive result = archiveFactory.createNewArchive(data);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of createArchives method, of class DataArchiveFactory.
//     * TODO
//     */
//    @Test
//    public void testCreateArchives() {       
//        ArchiveRequest request = new ArchiveRequest(name, dataType,date,endDate);
//        List<Archive> result = new ArrayList();//archiveFactory.createArchives(archiveService, request);
//        Archive archive = result.get(0);
//        assertTrue(result.size() > 0);
//        if(archive != null){
//          assertEquals("Archive data type is the same", archive.getType(),dataType);
//        }
//    }
//
//    /**
//     * Test of createObject method, of class DataArchiveFactory.
//     * @throws java.lang.Exception
//     */
//    @Test
//    public void testCreateObject() throws Exception {
//        ArchiveRequest request = new ArchiveRequest(name, dataType,date,endDate);
//        List<Archive> archives = new ArrayList();//archiveFactory.createArchives(archiveService, request);
//        IArchiver archiver =  new DataArchiver();
//        List result = archiveFactory.createObject(archives, dataType, archiver);
//        assertTrue(result.size() > 0);
//        //assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//}
