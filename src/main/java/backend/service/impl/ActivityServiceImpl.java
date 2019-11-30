package backend.service.impl;

import backend.dao.repository.ActivityRepository;
import backend.pojo.Activity;
import backend.service.ActivityService;
import common.service.Impl.CURDServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author: OY
 * @date: 13:26 2019/11/30
 */
@Service
public class ActivityServiceImpl extends CURDServiceImpl<Activity,String,ActivityRepository>  implements ActivityService{

}
