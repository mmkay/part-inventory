package pl.mmkay.inventory.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/part")
public class PartController {
    @Autowired
    private PartRepository partRepository;

    @GetMapping("all")
    public List<Part> getAllParts() {
        return (List<Part>) partRepository.findAll();
    }

    @GetMapping("{id}")
    public Part getPartById(@PathVariable("id") UUID uuid) {
        return partRepository.findOne(uuid);
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
    public Part savePart(@RequestBody Part part) {
        Part savedPart = partRepository.save(part);
        return savedPart;
    }
}
