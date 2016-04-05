package com.att.archive.restful.query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;

/**
 * SimpleSolrQueryHandler -- Default concrete implementation of the Query
 * Handler
 *
 * @author ebrimatunkara
 */
public class SimpleSolrQueryHandler extends SolrQueryHandler {

    public SimpleSolrQueryHandler() {
    }

    public SimpleSolrQueryHandler(SolrQueryHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean isValidQuery(SearchQuery query) {
        return true;
    }

    @Override
    public Query createQueryCriteria(SearchQuery query) {
        Query qCriteria = createConditions(query.getQuery());
        if(!query.getSort().isEmpty()){
          qCriteria.addSort(createSortOrders(query.getSort()));
        }
        return qCriteria;
    }

    private Query createConditions(Map terms) {
        Criteria conditions;
        SimpleQuery query = new SimpleQuery();
        Iterator<?> itr = terms.entrySet().iterator();
        Map.Entry<String, String> entry;
        while (itr.hasNext()) {
            entry = (Map.Entry<String, String>) itr.next();
            conditions = new Criteria(entry.getKey()).is(entry.getValue());
            query.addCriteria(conditions);
        }
        return query;
    }

    private Sort createSortOrders(Map sort) {
        List<Order> orders = new ArrayList();
        Iterator itr = sort.entrySet().iterator();
        Map.Entry<String, String> entry;
        while (itr.hasNext()) {
            entry = (Map.Entry<String, String>) itr.next();
            orders.add(new Order(Sort.Direction.fromString(entry.getValue()), entry.getKey()));
        }
        return new Sort(orders);
    }

}
