package BookRentalSystem;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProcurementbookRepository extends PagingAndSortingRepository<Procurementbook, Long>{


}