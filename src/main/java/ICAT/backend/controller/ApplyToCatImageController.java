package ICAT.backend.controller;

import ICAT.backend.pojo.ApplyToCatImage;
import ICAT.backend.service.ApplyToCatImageService;
import ICAT.common.controller.CURDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Shidan Cheng
 * @date 14:52 2019/11/30
 */
@RestController
@RequestMapping(value = "/api/ApplyToCatImages", produces = "application/json;charset=utf-8")
public class ApplyToCatImageController extends CURDController<ApplyToCatImage, Integer, ApplyToCatImageService> {
    @Autowired
    ApplyToCatImageService applyToCatImageService;

    @GetMapping(value = "/AuditPass")
    public ResponseEntity auditPass(@RequestParam Integer applicationId){
        return applyToCatImageService.auditPass(applicationId);
    }
}