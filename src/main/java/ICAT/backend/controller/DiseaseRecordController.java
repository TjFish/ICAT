package ICAT.backend.controller;

import ICAT.backend.pojo.DiseaseRecord;
import ICAT.backend.service.DiseaseRecordService;
import ICAT.common.controller.CURDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: OY
 * @date: 18:57 2019/11/28
 */
@RestController
@RequestMapping(value = "/api/DiseaseRecords", produces = "application/json;charset=utf-8")
public class DiseaseRecordController extends CURDController<DiseaseRecord,String,DiseaseRecordService> {

    @Autowired
    DiseaseRecordService diseaseRecordService;

}
