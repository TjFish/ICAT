package ICAT.backend.controller;

import ICAT.backend.pojo.Cat;
import ICAT.backend.pojo.DiseaseRecord;
import ICAT.backend.pojo.Image;
import ICAT.backend.service.CatService;
import ICAT.common.controller.CURDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Shidan Cheng
 * @date 12:07 2019/11/30
 */
@RestController
@RequestMapping(value = "/api/Cats", produces = "application/json;charset=utf-8")
public class CatController extends CURDController<Cat, String, CatService> {
    @Autowired
    private CatService catService;

    @GetMapping(value = "/Image")
    public ResponseEntity<List<Image>> getAllImageByCatId(@RequestParam String id) {
        return new ResponseEntity<>(catService.getAllImageByCatId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/Diserecord")
    public ResponseEntity<List<DiseaseRecord>> getAllDiseaseRecordByCatId(@RequestParam String id) {
        return new ResponseEntity<>(catService.getAllDiseaseRecordByCatId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/Color")
    public ResponseEntity<List<Cat>> getAllCatByCatColor(@RequestParam String id) {
        return new ResponseEntity<>(catService.getAllCatByCatColor(id), HttpStatus.OK);
    }

    @GetMapping(value = "/GetCatList")
    public ResponseEntity<List<Cat>> getCatList(){
        return new ResponseEntity<>(catService.getCatList(), HttpStatus.OK);
    }
}
