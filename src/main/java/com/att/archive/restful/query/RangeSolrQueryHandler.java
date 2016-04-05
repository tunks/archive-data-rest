
package com.att.archive.restful.query;

import com.att.archive.restful.util.DateDeserializer;
import com.att.archive.restful.util.DateUtil;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
/*
 * @author ebrimatunkara
 */
public class RangeSolrQueryHandler extends SolrQueryHandler {
    @Override
    public boolean isValidQuery(SearchQuery query) {
        return !query.getGroup().isEmpty();
    }

    @Override
    public Query createQueryCriteria(SearchQuery query) {
        return createRangeOptions(query.getRange());
    }
    
    private Query createRangeOptions(Map terms) {
        SimpleQuery qCriteria = new SimpleQuery(); 
        Iterator itr = terms.entrySet().iterator();
        Entry<String, String> entry;
        while (itr.hasNext()) {
            try {
                entry = (Entry<String, String>) itr.next();
                qCriteria.addCriteria(createRangeCriteria(entry));
            } catch (ParseException ex) {
                Logger.getLogger(RangeSolrQueryHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return qCriteria;
   }

   private Criteria  createRangeCriteria(Entry<String,String> entry) throws ParseException{
         Object[] values = rangeValues(entry.getValue());
         return new Criteria(entry.getKey()).between(values[0], values[1]);
   }
   
   private String[] splitRangeValues(String rangeValue){
        return rangeValue.split("TO", 2);
   }
   /**
    * get the range values
    **/
   private Object[] rangeValues(String value) {
           String[] values = splitRangeValues(value);
            //determine if the two range values are valid date
           if(DateUtil.isValidateDate(values[0]) && DateUtil.isValidateDate(values[1])){
               try {
                   return rangeDateValues(values);
               } catch (ParseException ex) {
                   Logger.getLogger(RangeSolrQueryHandler.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           return values;
   }
   private Date[] rangeDateValues(String[] values) throws ParseException{
        Date[] dateValues =  new Date[2];
        dateValues[0] = DateUtil.parseDate(values[0]);
        dateValues[1] = DateUtil.parseDate(values[1]);
        return dateValues;
   }
}
