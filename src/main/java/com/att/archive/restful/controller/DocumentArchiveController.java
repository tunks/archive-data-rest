package com.att.archive.restful.controller;

import com.att.archive.restful.model.ArchiveDocument;
import com.att.archive.restful.query.QueryHandler;
import com.att.archive.restful.query.SearchQuery;
import com.att.archive.restful.query.SolrQueryHandler;
import com.att.archive.restful.service.ServiceBase;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Archive Document controller class
 * Document basically represent archive resource that is indexed in solr
 * @author ebrimatunkara
 */
@RestController
@RequestMapping("/att/archives/search")
public class DocumentArchiveController extends ControllerBase<ArchiveDocument>{
    /**
     * Document query handler instance to handler queries on the document resources
     **/
    @Autowired
    private SolrQueryHandler solrQueryHandler;
    /**
     * Document service instance that manages Archive Document resources
     **/
    @Autowired
    private ServiceBase<ArchiveDocument,String> documentArchiveService;
  
    @Override
    protected ServiceBase getService() {
      return documentArchiveService;
    }

    @Override
    protected QueryHandler getQueryHandler() {
       return solrQueryHandler;
    }
    
    //@RequestParam MultiValueMap<String, String> params, Pageable page

    @RequestMapping(method=RequestMethod.GET)
    public Page<ArchiveDocument> get( /*@RequestParam(value = "fq", required = false) Map<String,String> fieldQuery,
                                      @RequestParam(value = "range", required = false) Map<String,String> range,
                                      @RequestParam(value = "groupBy", required = false) List<String> group,
*/
            @RequestParam MultiValueMap<String, String> params,
                                      Pageable page){
        System.out.println("Request params "+params);
        System.out.println("page "+page);
        return  null; //this.get( new SearchQuery(fieldQuery,range,group,page));
    }

    @RequestMapping(method=RequestMethod.PUT)  
    @Override
    public void update(ArchiveDocument object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @RequestMapping(method=RequestMethod.POST)
    @Override
    public void create(ArchiveDocument object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
