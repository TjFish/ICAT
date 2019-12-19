package ICAT.backend.controller;

import ICAT.backend.pojo.IoRecord;
import ICAT.backend.service.IoRecordsService;
import ICAT.common.controller.CURDController;
import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/IoRecords", produces = "application/json;charset=utf-8")
public class IoRecordController extends CURDController<IoRecord,String,IoRecordsService> {

}
