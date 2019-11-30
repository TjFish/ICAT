package backend.controller;

import backend.pojo.CatColor;
import backend.service.CatColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 12:19 2019/11/30
 */
@RestController
@RequestMapping(value = "CatColors", produces = "application/json;charset=utf-8")
public class CatColorController {
    @Autowired
    CatColorService catColorService;

    @GetMapping(value = "/")
    public List<CatColor> getAllCatColor() {
        return catColorService.queryAllCatColor();
    }

    @GetMapping(value = "/{colorId}")
    public Optional<CatColor> getCatColorById(@PathVariable("colorId") String id) {
        return catColorService.queryCatColorById(id);
    }

    @PostMapping(value = "/")
    public void addCatColor(@RequestBody CatColor catColor) {
        catColorService.addCatColor(catColor);
    }

    @DeleteMapping(value = "/{colorId}")
    public void deleteCatColor(@PathVariable("colorId") String id) {
        catColorService.deleteCatColorById(id);
    }

    @PutMapping(value = "/")
    public void putCatColor(CatColor catColor) {
        catColorService.updateCatColor(catColor);
    }
}
