package ICAT.backend.service.impl;

import ICAT.backend.pojo.Activity;
import ICAT.backend.pojo.Image;
import ICAT.backend.service.ActivityService;
import ICAT.backend.dao.repository.ActivityRepository;
import ICAT.backend.service.ImageService;
import ICAT.backend.service.SequenceService;
import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: OY
 * @date: 13:26 2019/11/30
 */

@Service
public class ActivityServiceImpl extends CURDServiceImpl<Activity,String,ActivityRepository>  implements ActivityService {
    @Autowired
    SequenceService sequenceService;

    @Override
    public Activity add(Activity activity) {
        activity.setActivityId(sequenceService.getNextActivityId());;
        return super.add(activity);
    }
}
