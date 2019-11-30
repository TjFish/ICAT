package backend.controller;

import backend.dao.repository.ActivityRepository;
import backend.pojo.Activity;
import backend.service.ActivityService;
import backend.service.SequenceService;
import common.controller.CURDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: OY
 * @date: 16:12 2019/11/30
 */
@RestController
@RequestMapping(value = "/api/Activitys", produces = "application/json;charset=utf-8")
public class ActivityController extends CURDController<Activity,String,ActivityService> {
    @Autowired
    SequenceService sequenceService;
    @Override
    public void add(@RequestBody Activity e) {
        e.setActivityId(sequenceService.getNextActivityId());;
        super.add(e);
    }
}
