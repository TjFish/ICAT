package ICAT.backend.controller;

import ICAT.backend.pojo.Cat;
import ICAT.backend.pojo.DiseaseRecord;
import ICAT.backend.pojo.Image;
import ICAT.backend.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 12:07 2019/11/30
 */
@RestController
@RequestMapping(value = "/api/Cats", produces = "application/json;charset=utf-8")
public class CatController {
    @Autowired
    CatService catService;

    @GetMapping(value = "/")
    @ResponseBody
    public List<Cat> getAllCat() {
        return catService.queryAllCat();
    }

    @GetMapping(value = "/{catId}")
    @ResponseBody
    public Optional<Cat> getCatById(@PathVariable("catId") String id) {
        return catService.queryCatById(id);
    }

    @PostMapping(value = "/")
    public void addCat(@RequestBody Cat cat) {
        catService.addCat(cat);
    }


    @DeleteMapping(value = "/{catId}")
    public void deleteCat(@PathVariable("catId") String id) {
        catService.deleteCatById(id);
    }

    @PutMapping(value = "/")
    public void putCat(Cat cat) {
        catService.updateCat(cat);
    }

    @GetMapping(value = "/Image")
    @ResponseBody
    public List<Image> getAllImageByCatId(@RequestParam String id) {
        return catService.getAllImageByCatId(id);
    }


    @GetMapping(value = "/Diserecord")
    @ResponseBody
    public List<DiseaseRecord> getAllDiseaseRecordByCatId(@RequestParam String id) {
        return catService.getAllDiseaseRecordByCatId(id);
    }

    @GetMapping(value = "/Color")
    public List<Cat> getAllCatByCatColor(@RequestParam String id){
        return catService.getAllCatByCatColor(id);
    }
}
