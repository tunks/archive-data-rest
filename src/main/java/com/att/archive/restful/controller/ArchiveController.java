//package com.att.archive.restful.controller;
//
//import com.att.archive.restful.model.ArchiveEntity;
//import com.att.archive.restful.query.QueryHandler;
//import com.att.archive.restful.service.ServiceBase;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
///*
//  Archive Resource controller class
//*/
//@RestController
//@RequestMapping("/att/archives")
//public class ArchiveController extends ControllerBase<ArchiveEntity>{
//    @Autowired
//    private ServiceBase<ArchiveEntity,String> archiveService;  
//    
//    @Override
//    protected ServiceBase getService() {
//       return archiveService;
//    }
//
//    @Override
//    protected QueryHandler getQueryHandler() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//     
//    /**
//     * Request method to create and persist Archive resource
//     **/
//    @RequestMapping(method=RequestMethod.POST)
//    @ResponseBody
//    @Override
//    public void create(ArchiveEntity object) {
//         getService().save(object);
//    }
//
//    /**
//     * Request method to update and persist Archive resource
//     **/
//    @RequestMapping(method=RequestMethod.PUT)
//    @ResponseBody
//    @Override
//    public void update(ArchiveEntity object) {
//       getService().save(object);
//    }
//}