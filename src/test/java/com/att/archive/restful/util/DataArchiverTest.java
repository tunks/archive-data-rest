
package com.att.archive.restful.util;

import com.att.archive.restful.model.Archive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ebrima
 */


public class DataArchiverTest {
    
    public DataArchiverTest() {
    }
    
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
     * Test of compress method, of class DataArchiver.
     */
    @org.junit.Test
    public void testCompress_String_Archive() throws Exception {
        System.out.println("compress");
        String input = "\"{test: g}\"";
        Archive archive = new Archive();
        DataArchiver instance = new DataArchiver();
        instance.compress(input, archive);
        String out = instance.decompress(archive);
        System.out.println("output "+out);
        assertEquals(input,out);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of decompress method, of class DataArchiver.
     */
//    @org.junit.Test
//    public void testDecompress() throws Exception {
//        System.out.println("decompress");
//        Archive archive = null;
//        DataArchiver instance = new DataArchiver();
//        String expResult = "";
//        String result = instance.decompress(archive);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of compress method, of class DataArchiver.
//     */
//    @org.junit.Test
//    public void testCompress_String() throws Exception {
//        System.out.println("compress");
//        String input = "";
//        DataArchiver instance = new DataArchiver();
//        instance.compress(input);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
    
}
