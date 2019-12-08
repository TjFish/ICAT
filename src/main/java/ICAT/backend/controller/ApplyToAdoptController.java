package ICAT.backend.controller;

import ICAT.backend.pojo.ApplyToAdopt;
import ICAT.backend.service.ApplyToAdoptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 14:33 2019/11/30
 */
@RestController
@RequestMapping(value = "ApplyToAdopts", produces = "application/json;charset=utf-8")
public class ApplyToAdoptController {
    @Autowired
    ApplyToAdoptService applyToAdoptService;

    @GetMapping(value = "/")
    public List<ApplyToAdopt> getAllApplyToAdopt() {
        return applyToAdoptService.queryAllApplyToAdopt();
    }

    @GetMapping(value = "/{applicationId}")
    public Optional<ApplyToAdopt> getApplyToAdoptById(@PathVariable("applicationId") String id) {
        return applyToAdoptService.queryApplyToAdoptById(id);
    }

    @PostMapping(value = "/")
    public void addApplyToAdopt(@RequestBody ApplyToAdopt application) {
        applyToAdoptService.addApplyToAdopt(application);
    }

    @DeleteMapping(value = "/{applicationId}")
    public void deleteApplyToAdoptById(@PathVariable("applicationId") String id) {
        applyToAdoptService.deleteApplyToAdoptById(id);
    }

    @PutMapping(value = "/")
    public void putApplyToAdopt(ApplyToAdopt application) {
        applyToAdoptService.updateApplyToAdopt(application);
    }

    @GetMapping(value = "/AuditPass")
    public void auditPassApplyToAdopt(@RequestParam  String applicationId){
        //todo: 领养申请通过的实现

    }
}
