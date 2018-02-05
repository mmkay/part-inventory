package pl.mmkay.inventory.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/part")
public class PartController {
    @Autowired
    private PartRepository partRepository;
    @Autowired
    private PartCompatibilityRepository partCompatibilityRepository;

    @GetMapping("all")
    public Page<Part> getAllParts(Pageable p) {
        return partRepository.findAll(p);
    }

    @GetMapping("{id}")
    public Part getPartById(@PathVariable("id") UUID uuid) {
        return partRepository.findOne(uuid);
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
    public Part savePart(@RequestBody Part part) {
        return partRepository.save(part);
    }

    @PutMapping("{id}")
    public Part updatePart(@PathVariable("id") UUID uuid, @RequestBody Part part) {
        return partRepository.save(part);
    }

    @DeleteMapping("{id}")
    public void deletePartById(@PathVariable("id") UUID uuid) {
        partRepository.delete(uuid);
    }

    @GetMapping("{id}/compatible")
    public Page<Part> getCompatibleParts(@PathVariable("id") UUID uuid, Pageable p) {
        return partRepository.findCompatible(uuid, p);
    }

    @PostMapping("{id1}/compatible/{id2}")
    public PartCompatibility addCompatibility(@PathVariable("id1") UUID uuid1, @PathVariable("id2") UUID uuid2) {
        PartCompatibility compatibility = new PartCompatibility();

        Part part1 = partRepository.findOne(uuid1);
        Part part2 = partRepository.findOne(uuid2);

        if (part1 != null && part2 != null) {
            compatibility.setPart1(part1);
            compatibility.setPart2(part2);
            return partCompatibilityRepository.save(compatibility);
        }

        return null;
    }

    @DeleteMapping("{id1}/compatible/{id2}")
    @Transactional
    public void deleteCompatibility(@PathVariable("id1") UUID uuid1, @PathVariable("id2") UUID uuid2) {
        partCompatibilityRepository.deleteCompatibility(uuid1, uuid2);
    }
}
