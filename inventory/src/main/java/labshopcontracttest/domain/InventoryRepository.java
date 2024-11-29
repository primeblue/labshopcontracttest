package labshopcontracttest.domain;

import java.util.Date;
import java.util.List;
import labshopcontracttest.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "inventories",
    path = "inventories"
)
public interface InventoryRepository
    extends PagingAndSortingRepository<Inventory, Long> {
    @Query(
        value = "select inventory " +
        "from Inventory inventory " +
        "where(:id is null or inventory.id = :id) and (:stock is null or inventory.stock = :stock)"
    )
    Inventory GetInventory(Long id, Integer stock);
}
