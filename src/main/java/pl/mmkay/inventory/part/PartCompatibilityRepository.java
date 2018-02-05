package pl.mmkay.inventory.part;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PartCompatibilityRepository extends PagingAndSortingRepository<PartCompatibility, Long> {
    @Modifying(clearAutomatically = true)
    @Query(value = "" +
            "delete from part_compatibility pc " +
            "where (pc.part1 = ?1 and pc.part2 = ?2) or (pc.part1 = ?2 and pc.part2 = ?1)",
            nativeQuery = true)
    void deleteCompatibility(UUID uuid1, UUID uuid2);

    List<PartCompatibility> findByPart1OrPart2(Part part1, Part part2);
}
