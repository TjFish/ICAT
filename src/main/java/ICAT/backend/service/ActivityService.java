package ICAT.backend.service;

import ICAT.backend.pojo.Activity;
import ICAT.common.service.CURDService;
import org.springframework.stereotype.Service;

/**
 * @author: OY
 * @date: 13:25 2019/11/30
 */
@Service
public interface ActivityService extends CURDService<Activity, String> {
    
}
