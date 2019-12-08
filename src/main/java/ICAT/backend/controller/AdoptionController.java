package ICAT.backend.controller;

import ICAT.backend.pojo.Adoption;
import ICAT.backend.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 14:17 2019/11/30
 */
@RestController
@RequestMapping(value = "Adoptions", produces = "application/json;charset=utf-8")
public class AdoptionController {
    @Autowired
    AdoptionService adoptionService;

    @GetMapping(value = "/")
    public List<Adoption> getAllAdoption() {
        return adoptionService.queryAllAdoption();
    }

    @GetMapping(value = "/{catId}")
    public Optional<Adoption> getAdoptionById(@PathVariable("catId") String id) {
        return adoptionService.queryAdoptionById(id);
    }

    @PostMapping(value = "/")
    public void addAdoption(@RequestBody Adoption adoption) {
        adoptionService.addAdoption(adoption);
    }

    @DeleteMapping(value = "/{catId}")
    public void deleteAdoption(@PathVariable("catId") String id) {
        adoptionService.deleteAdoptionById(id);
    }

    @PutMapping(value = "/")
    public void putAdoption(Adoption adoption) {
        adoptionService.updateAdoption(adoption);
    }

}
