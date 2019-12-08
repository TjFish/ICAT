package ICAT.backend.controller;

import ICAT.backend.pojo.ApplyToCatImage;
import ICAT.backend.pojo.Image;
import ICAT.backend.service.ApplyToCatImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 14:52 2019/11/30
 */
@RestController
@RequestMapping(value = "/api/ApplyToCatImages", produces = "application/json;charset=utf-8")
public class ApplyToCatImageController {
    @Autowired
    ApplyToCatImageService applyToCatImageService;

    @GetMapping(value = "/")
    @ResponseBody
    public List<ApplyToCatImage> getAllApplyToCatImage() {
        return applyToCatImageService.queryAllApplyToCatImage();
    }

    @GetMapping(value = "/{applicationId}")
    @ResponseBody
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
    public ResponseEntity auditPassApplyToCatImage(HttpServletRequest request, @RequestParam String applicationId) throws IOException {
        if (applyToCatImageService.auditPassApplyToCatImage(request, applicationId) != null) {
            return new ResponseEntity<>("成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("无指定ID", HttpStatus.NOT_FOUND);
        }
    }
}