package backend.controller;

import backend.pojo.DiseaseRecord;
import backend.service.DiseaseRecordService;
import backend.service.SequenceService;
import common.controller.CURDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author: OY
 * @date: 18:57 2019/11/28
 */
@RestController
@RequestMapping(value = "/api/DiseaseRecords", produces = "application/json;charset=utf-8")
public class DiseaseRecordController extends CURDController<DiseaseRecord,String,DiseaseRecordService> {
    @Autowired
    SequenceService sequenceService;

    @Override
    public void add(@RequestBody DiseaseRecord diseaseRecord) {
        diseaseRecord.setRecordId(sequenceService.getNextDiseaseRecordId());
        super.add(diseaseRecord);
    }
}
