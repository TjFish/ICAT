package ICAT.backend.controller;

import ICAT.backend.pojo.ApplyToCatImage;
import ICAT.backend.pojo.Image;
import ICAT.backend.service.ApplyToCatImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 14:52 2019/11/30
 */
@RestController
@RequestMapping(value = "ApplyToCatImages", produces = "application/json;charset=utf-8")
public class ApplyToCatImageController {
    @Autowired
    ApplyToCatImageService applyToCatImageService;

    @GetMapping(value = "/")
    public List<ApplyToCatImage> getAllApplyToCatImage() {
        return applyToCatImageService.queryAllApplyToCatImage();
    }

    @GetMapping(value = "/{applicationId}")
    public Optional<ApplyToCatImage> getApplyToCatImageById(@PathVariable("applicationId") String id) {
        return applyToCatImageService.queryApplyToCatImageById(id);
    }

    @PostMapping(value = "/")
    public void addApplyToCatImage(@RequestBody ApplyToCatImage application) {
        applyToCatImageService.addApplyToCatImage(application);
    }

    @DeleteMapping(value = "/{applicationId}")
    public void deleteApplyToCatImageById(@PathVariable("applicationId") String id) {
        applyToCatImageService.deleteApplyToCatImageById(id);
    }

    @PutMapping(value = "/")
    public void putApplyToCatImage(ApplyToCatImage application) {
        applyToCatImageService.updateApplyToCatImage(application);
    }

    @GetMapping(value = "/AuditPass")
    public Image auditPassApplyToCatImage(@RequestParam String applicationId) {
        //todo: 图片申请通过的实现
        return null;
    }
}