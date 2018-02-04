package pl.mmkay.inventory.part;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartRepository extends PagingAndSortingRepository<Part, UUID> {
}
