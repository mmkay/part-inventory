package pl.mmkay.inventory.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/part")
public class PartController {
    @Autowired
    private PartRepository partRepository;

    @GetMapping("all")
    public List<Part> getAllParts() {
        return (List<Part>) partRepository.findAll();
    }
}
