package ICAT.backend.controller;

import ICAT.backend.pojo.ApplyToAdopt;
import ICAT.backend.service.ApplyToAdoptService;
import ICAT.common.controller.CURDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author Shidan Cheng
 * @date 14:33 2019/11/30
 */
@RestController
@RequestMapping(value = "ApplyToAdopts", produces = "application/json;charset=utf-8")
public class ApplyToAdoptController extends CURDController<ApplyToAdopt, Integer, ApplyToAdoptService> {
    @Autowired
    ApplyToAdoptService applyToAdoptService;

    @GetMapping(value = "/AuditPass")
    public ResponseEntity auditPass(@RequestParam Integer applicationId){
        return applyToAdoptService.auditPass(applicationId);
    }
}
