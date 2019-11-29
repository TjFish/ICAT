package backend.controller;

import backend.pojo.DiseaseRecord;
import backend.service.DiseaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author: OY
 * @date: 18:57 2019/11/28
 */
@RestController
@RequestMapping(value = "/DiseaseRecord", produces = "application/json;charset=utf-8")
public class DiseaseRecordController {
    @Autowired
    DiseaseRecordService diseaseRecordService;

    @GetMapping(value = "/")
    public List<DiseaseRecord> getAllDiseaseRecord() {
        return diseaseRecordService.queryAllDiseaseRecord();
    }

    @GetMapping(value = "/{Id}")
    public Optional<DiseaseRecord> getDiseaseRecordById(@PathVariable("Id") String Id) {
        return diseaseRecordService.queryDiseaseRecordById(Id);
    }

    @PostMapping(value = "/")
    public void addDiseaseRecord(@RequestBody DiseaseRecord diseaseRecord) {
        diseaseRecordService.addDiseaseRecord(diseaseRecord);
    }

    @DeleteMapping(value = "/{Id}")
    public void deleteDiseaseRecord(@PathVariable("Id") String Id) {
        diseaseRecordService.deleteDiseaseRecordById(Id);
    }

    @PutMapping(value = "/")
    public void putDiseaseRecord(DiseaseRecord diseaseRecord) {
        diseaseRecordService.updateDiseaseRecord(diseaseRecord);
    }
}
