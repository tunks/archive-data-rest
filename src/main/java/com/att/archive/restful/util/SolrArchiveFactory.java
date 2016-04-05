
package com.att.archive.restful.util;

import com.att.archive.restful.model.ArchiveEntity;
import com.att.archive.restful.model.ArchiveDocument;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Solr archive factory class
 * @author ebrimatunkara
 */
public class SolrArchiveFactory implements ArchiveFactory<ArchiveEntity,ArchiveDocument>{
    @Override
    public List<ArchiveDocument> create(ArchiveEntity object) throws IOException {
        try {
            return createSolrDocuments(object);
        } catch (ParseException ex) {
            Logger.getLogger(SolrArchiveFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<ArchiveDocument> create(List<ArchiveEntity> object) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ArchiveDocument> create(List<ArchiveEntity> archives, IArchiver archiver) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<ArchiveDocument> createSolrDocuments(ArchiveEntity entity) throws IOException, ParseException{
        List<ArchiveDocument>  list = new ArrayList();
        String name = entity.getName();
        String type = entity.getDataType();
        Date date = DateUtil.parseDate(entity.getCreatedOn());
        JsonElement json;
        json = new JsonParser().parse(entity.getContent());
        if(json.isJsonArray()){
            for(JsonElement element : json.getAsJsonArray()){
               list.add(createSolrDocument(type,name,date,element));
            }
          }
          else{
             list.add(createSolrDocument(type,name,date,json));
          }  
        return list;
    }
    
    private ArchiveDocument createSolrDocument(String type, String name,  Date date,  JsonElement element){
        ArchiveDocument document = new ArchiveDocument(type, name,date);
        Iterator itr = element.getAsJsonObject().entrySet().iterator();
        Map<String,String> textContent = new HashMap();
        Map<String,Double> numericContent = new HashMap();
        Entry<String,JsonPrimitive> entry;
        JsonPrimitive value;
        while(itr.hasNext()){
              entry =  (Entry<String, JsonPrimitive>) itr.next();
              value =  entry.getValue();
              if(value.isNumber()){
                 numericContent.put(entry.getKey(), value.getAsNumber().doubleValue());
              }
              else{
                 textContent.put(entry.getKey(), entry.getValue().getAsString());
              }
        }
        document.setTextContent(textContent);
        document.setNumericContent(numericContent);
        return document;
    }
}
