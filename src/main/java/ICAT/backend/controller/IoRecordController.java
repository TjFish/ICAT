package ICAT.backend.controller;

import ICAT.backend.pojo.IoRecord;
import ICAT.backend.service.IoRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/IoRecords", produces = "application/json;charset=utf-8")
public class IoRecordController {
    @Autowired
    IoRecordsService ioRecordsService;

    @GetMapping(value = "/")
    public List<IoRecord> getAllIoRecords(){
        return ioRecordsService.queryAll();
    }

    @GetMapping(value = "/{id}")
    public IoRecord getIoRecordById(@PathVariable("id") String id){
        return ioRecordsService.queryById(id);
    }

    @PostMapping(value = "/")
    public IoRecord addIoRecord(@RequestBody IoRecord ioRecord){
        return ioRecordsService.add(ioRecord);
    }

    @PutMapping(value = "/")
    public ResponseEntity updateIoRecord(@RequestBody IoRecord ioRecord){
        ioRecordsService.update(ioRecord.getIoId(), ioRecord);
        return new ResponseEntity<>("删除成功", HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteIoRecord(@PathVariable("id")String id){
        ioRecordsService.deleteById(id);
        return new ResponseEntity<>("删除成功",HttpStatus.NO_CONTENT);
    }
}
