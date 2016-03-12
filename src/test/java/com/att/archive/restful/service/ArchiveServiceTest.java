
package com.att.archive.restful.service;

import com.att.archive.restful.controller.ArchiveRequest;
import com.att.archive.restful.model.Archive;
import com.att.archive.restful.util.DateDeserializer;
import com.att.archive.restful.util.IArchiver;
import java.text.ParseException;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author ebrima
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-spring-config.xml"})
public class ArchiveServiceTest {
    @Autowired
    ArchiveService archiveService; 
    @Autowired 
    IArchiver archiver ;
    
    final String content =  "[{ \"name\": \"active\", \"type\": \"TICKET_TYPE\", \"count\" : 100},{ \"name\": \"active\", \"type\": \"TICKET_TYPE\", \"count\" : 100},{ \"name\": \"active\", \"type\": \"TICKET_TYPE\", \"count\" : 100},{ \"name\": \"active\", \"type\": \"TICKET_TYPE\", \"count\" : 100},{ \"name\": \"active\", \"type\": \"TICKET_TYPE\", \"count\" : 100},{ \"name\": \"active\", \"type\": \"TICKET_TYPE\", \"count\" : 100}]";
    
    public ArchiveServiceTest() {}
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {

    }

    /**
     * Test of findAll method, of class ArchiveService.
     */
    @Test
    public void testFindAll_0args() {
        System.out.println("findAll");
        List<Archive> expResult = null;
        List<Archive> result =archiveService.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   //     fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class ArchiveService.
     */
    @Test
    public void testFindAll_List() {
        System.out.println("findAll");
        Map composite = new HashMap();
        List<Archive> expResult = null;
        List<Archive> result =archiveService.findAll(composite);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 //       fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class ArchiveService.
     * @throws java.text.ParseException
     */
    @Test
    public void testFindAll_4args() throws ParseException {
      // request.setDataType("TICKET_STATE");
        Date date = DateDeserializer.deserialize("2015-11-28T10:23:01Z");
        Date endDate = DateDeserializer.deserialize("2015-11-30T12:23:01Z");
        String type = "TICKET_STATE";
        Set<Map<String, Object>> composites  = new HashSet();
        Map<String, Object> composite = new HashMap();
        //insert first composite item
        composite.put("rsLine", "WaAN");
        composites.add(composite);
        //insert second composite
        composite = new HashMap();
        composite.put("count", "1000");
        composites.add(composite);
        List<Archive> result =archiveService.findAll(date, endDate, type, composites);
        assertTrue(result.size() >0);
        assertEquals("archive composite exists", result.get(0).getType(), type);
        // TODO review the generated test code and remove the default call to fail
    }

    /**
     * Test of find method, of class ArchiveService.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String id = "";
        Archive expResult = null;
        Archive result =archiveService.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class ArchiveService.
     * @throws java.text.ParseException
     */
    @Test
    public void testSave_Archive() throws ParseException {
       System.out.println("save");
       Map<String,Object> composite = new HashMap();
       ArchiveRequest request = new ArchiveRequest();
       request.setContent(content);
       request.setName("bucket");
       request.setDataType("TICKET_STATE");
       request.setDate("2015-11-29T12:23:01Z");
       //insert first composite
       composite.put("rsLine", "WAN");
       request.getComposites().add(composite);
       //insert second composite
       composite = new HashMap();
       composite.put("count", "1000");
       request.getComposites().add(composite);
       Archive archive = archiveService.save(request, archiver);
       assertEquals("save archive to be true", archive.getType(), request.getDataType());
       // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAll method, of class ArchiveService.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        //archiveService.deleteAll();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class ArchiveService.
     */
    @Test
    public void testSave_ArchiveRequest_IArchiver() {
        System.out.println("save");
        ArchiveRequest request = null;
        IArchiver archiver = null;
        archiveService.save(request, archiver);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findArchives method, of class ArchiveService.
     */
    @Test
    public void testFindArchives_String_String() {
        System.out.println("findArchives");
        String type = "";
        String name = "";
//        List<Archive> expResult = null;
//        List<Archive> result =archiveService.findArchives(type, name);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findArchives method, of class ArchiveService.
     */
    @Test
    public void testFindArchives_Date_String() {
        System.out.println("findArchives");
        Date date = null;
        String type = "";
//        List<Archive> expResult = null;
//        List<Archive> result =archiveService.findArchives(date, type);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findArchives method, of class ArchiveService.
     * @throws java.text.ParseException
     */
    @Test
    public void testFindArchives_3args() throws ParseException {
        Date date =  DateDeserializer.deserialize("2015-10-25T19:08:56Z");   
        Date endDate = DateDeserializer.deserialize("2015-12-04T19:08:56Z"); 
        String type = "TICKET_STATE";
        List<Archive> result =archiveService.findArchives(date, endDate, type);
        assertTrue(result.size() > 0);
    }

    /**
     * Test of findArchives method, of class ArchiveService.
     * @throws java.text.ParseException
     */
    @Test
    public void testFindArchives_4args() throws ParseException {
        Date date =  DateDeserializer.deserialize("2015-10-25T19:08:56Z");   
        Date endDate = DateDeserializer.deserialize("2015-12-04T19:08:56Z"); 
        String type = "bucket";
        String name = "TICKET_TYPE";
        List<Archive> result =archiveService.findArchives(date, endDate, type, name);
        assertTrue(result.size() > 0);
        
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
