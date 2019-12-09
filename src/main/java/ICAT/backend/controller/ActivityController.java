package ICAT.backend.controller;

import ICAT.backend.pojo.Activity;
import ICAT.backend.service.ActivityService;
import ICAT.common.controller.CURDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: OY
 * @date: 16:12 2019/11/30
 */
@RestController
@RequestMapping(value = "/api/Activities", produces = "application/json;charset=utf-8")
public class ActivityController extends CURDController<Activity,String, ActivityService> {
}
