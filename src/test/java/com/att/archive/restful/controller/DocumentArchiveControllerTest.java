/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.archive.restful.controller;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.util.LinkedMultiValueMap;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author ebrimatunkara
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-config.xml"})
public class DocumentArchiveControllerTest {
    @Autowired
    private DocumentArchiveController documentArchiveController;
    
//    @Inject 
//    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;
    //private WebApplicationContext ctx;
    String requestBaseUrl = "/att/archives/search";
    
    private MockMvc mockMvc;

    Map<String,String> query;
    public DocumentArchiveControllerTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(documentArchiveController)
                                      .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                                      .build();
        query = new HashMap();
        query.put("name", "TICKET_TYPE");
    }

    @After
    public void tearDown() {}

    /**
     * Test of getArchiveObjects method, of class ArchiveController.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetArchiveObjects() throws Exception {
        System.out.println("getArchiveObjects");
//       
//        MultiValueMap<String,String> params = new LinkedMultiValueMap();
//        params.add("query","{\"name\":\"TICKET_TYPE\"}");
//        params.add("query","{\"type\":\"bucket\"}");
//        params.add("group", "rsLine_t");
//        UriComponents uriComponent = UriComponentsBuilder
//                                       .newInstance()
//                                       .path(requestBaseUrl)
//                .queryParam("fq", "{\"name\":\"TICKET_TYPE\"}")
//                                      //  .queryParams(params)
//                                        .build();
//     
//        System.out.println("uriComponent.toUriString() "+uriComponent.toUriString());
//        mockMvc.perform(get(uriComponent.getPath())
//                            .params(uriComponent.getQueryParams())
//                            .param("sort","created_date,asc"))
//                       .andExpect(status().isOk())  
//                       .andExpect(content().contentType("application/json;charset=UTF-8"));
                //.andExpect(jsonPath("id").value(id));
    }

    /**
     * Test of saveArchives method, of class ArchiveController.
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveArchives() throws Exception {
         String data = "{\"name\": \"test\"}";
         mockMvc.perform(post(requestBaseUrl+"/search").content(data).contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().is4xxClientError());
    }

    /**
     * Test of getArchive method, of class ArchiveController.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetArchive() throws Exception {
        String id = "1beb8d85-5bf8-40ad-a2bf-7a8be884a7e2";
        mockMvc.perform(get(requestBaseUrl+"/{id}", id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("id").value(id));
    }

    /**
     * Test of deleteAllArchives method, of class ArchiveController.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteAllArchives() throws Exception {
           mockMvc.perform(delete(requestBaseUrl))
                  .andExpect(status().isOk());
    }

}
