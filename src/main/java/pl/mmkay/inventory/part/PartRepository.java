package pl.mmkay.inventory.part;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartRepository extends PagingAndSortingRepository<Part, UUID> {

    @Query(value =
            "select distinct p.* from part p where p.id in (" +
            "   (select part2 as id from part_compatibility where part1 = ?1) union " +
            "   (select part1 as id from part_compatibility where part2 = ?1))" +
            " --#pageable\n",
            nativeQuery = true)
    Page<Part> findCompatible(UUID uuid, Pageable p);
}
