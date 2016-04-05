
package com.att.archive.restful.repositories;

import com.att.archive.restful.query.SearchQuery;
import com.att.archive.restful.query.QueryHandler;
import java.io.Serializable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * CustomBaseRepository interface
 * @author ebrimatunkara
 * @param <T>, Repository model class type
 * @param <ID>
 */
@NoRepositoryBean
public interface CustomBaseRepository<T,ID extends Serializable> extends PagingAndSortingRepository<T,ID>{
       public Page<T> search(QueryHandler<?> handler, SearchQuery query); 
//        public T findById(ID id);
}
