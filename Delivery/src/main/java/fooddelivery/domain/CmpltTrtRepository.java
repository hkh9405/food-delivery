package fooddelivery.domain;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="cmpltTrts", path="cmpltTrts")
public interface CmpltTrtRepository extends PagingAndSortingRepository<CmpltTrt, String>{

}
