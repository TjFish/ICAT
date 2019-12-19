package ICAT.backend.controller;

import ICAT.backend.pojo.Activity;
import ICAT.backend.pojo.Image;
import ICAT.backend.service.ActivityService;
import ICAT.backend.service.ImageService;
import ICAT.common.controller.CURDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: OY
 * @date: 16:12 2019/11/30
 */
@RestController
@RequestMapping(value = "/api/Activities", produces = "application/json;charset=utf-8")
public class ActivityController extends CURDController<Activity,String, ActivityService> {
    @Autowired
    ImageService imageService;

    @Autowired
    ActivityService activityService;

    @Override
    public ResponseEntity<List<Activity>> getAll(){
        List<Activity> activities=activityService.queryAll();
        for (Activity a:activities) {
            if(a.getActivityCover()!=null) {
                Image cover = imageService.getImageById(a.getActivityCover());
                if (cover != null) {
                    a.setCoverImageUrl(cover.getImageUrl());
                }
            }
        }
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }
}
