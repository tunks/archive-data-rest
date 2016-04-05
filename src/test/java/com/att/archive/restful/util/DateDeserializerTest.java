/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ebrimatunkara
 */
public class DateDeserializerTest {
    
    public DateDeserializerTest() {
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
     * Test of parseDate method, of class DateDeserializer.
     */
    @Test
    public void testDeserialize_3args() {
        System.out.println("deserialize");
        JsonElement element = null;
        Type arg1 = null;
        JsonDeserializationContext arg2 = null;
        DateDeserializer instance = new DateDeserializer();
        Date expResult = null;
        Date result = instance.deserialize(element, arg1, arg2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseDate method, of class DateDeserializer.
     */
    @Test
    public void testDeserialize_String() throws Exception {
        System.out.println("deserialize");
        String date = "";
        Date expResult = null;
        Date result = DateUtil.parseDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidateDate method, of class DateDeserializer.
     */
    @Test
    public void testIsValidateDate() {
        System.out.println("isValidateDate");
        String dateString = "2016-03-23T10:25:01Z";
        boolean expResult = true;
        boolean result = DateUtil.isValidateDate(dateString);
        assertEquals(expResult, result);
    }
    
}
