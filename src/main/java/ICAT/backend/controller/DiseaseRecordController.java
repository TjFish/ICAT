package ICAT.backend.controller;

import ICAT.backend.pojo.DiseaseRecord;
import ICAT.backend.service.DiseaseRecordService;
import ICAT.common.controller.CURDController;
import org.springframework.web.bind.annotation.*;

/**
 * @author: OY
 * @date: 18:57 2019/11/28
 */
@RestController
@RequestMapping(value = "/api/DiseaseRecords", produces = "application/json;charset=utf-8")
public class DiseaseRecordController extends CURDController<DiseaseRecord,String,DiseaseRecordService> {

}
