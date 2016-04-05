package com.att.archive.restful.repositories.solr;

import com.att.archive.restful.model.ArchiveDocument;
import com.att.archive.restful.query.SearchQuery;
import com.att.archive.restful.query.SolrQueryHandler;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.solr.common.util.DateUtil;
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
 * DocumentRepositoryImpl test class
 * @author ebrimatunkara
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@ActiveProfiles("dev")
public class DocumentRepositoryImplTest {
    @Autowired
    DocumentRepository solrDocumentRepository;

    @Autowired
    SolrQueryHandler solrQueryHandler;

    SearchQuery query;
    final String name = "TICKET_TYPE";
    final String type = "bucket";
    final String date = "2015-11-29T15:33:01Z";
    final String rsLine = "WAN";

    public DocumentRepositoryImplTest() {
    }

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
        q.put("_name_", name);
        q.put("_type_", type);
        Set<String> group = new HashSet();
        group.add("created_date");

        Map range = new HashMap();
        //range.put("created_date", "2016-03-20T10:23:01ZTO2016-03-27T10:23:10Z");
        range.put("count_d", "10TO100");

        Map sort = new HashMap();
        sort.put("created_date", "DESC");

        query.setQuery(q);
        query.setGroup(group);
        query.setRange(range);
        query.setSort(sort);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of save method
     * @throws java.text.ParseException
     *
     */
    @Test
    public void testSave() throws ParseException {
        Date createdOn = DateUtil.parseDate(date);
        ArchiveDocument document = new ArchiveDocument(type, name, createdOn);
        document.getTextContent().put("rsLine", rsLine);
        ArchiveDocument result = solrDocumentRepository.save(document);
        assertNotNull("Document saved successfully", result);
    }

    /**
     * Test of search method, of class DocumentRepositoryImpl.
     */
    @Test
    public void testSearch(){
        Page<ArchiveDocument> results = solrDocumentRepository.search(solrQueryHandler, query);
        int size = results.getContent().size();
        System.out.println("<<<<<<<<<<<<<<< search >>>>>>>>>>>>>>>>>>>" + size);
        assertTrue(size > 0);
        testSearch(results, size, 0);
    }

    private void testSearch(Page<ArchiveDocument> results, int size, int index) {
        if (size > 0) {
            ArchiveDocument doc = results.getContent().get(index);
            assertEquals(doc.get("_name_"), name);
        }
    }

    /**
     * Test of delete method
     *
     */
    @Test
    public void testDeleteAll() {
        solrDocumentRepository.deleteAll();
        Long size = solrDocumentRepository.count();
        assertTrue("Number of documents is zero", size.intValue() == 0);
    }

}
