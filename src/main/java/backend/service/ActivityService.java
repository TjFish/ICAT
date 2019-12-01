package backend.service;

import backend.pojo.Activity;
import common.service.CURDService;
import org.springframework.stereotype.Service;

/**
 * @author: OY
 * @date: 13:25 2019/11/30
 */
@Service
public interface ActivityService extends CURDService<Activity, String> {
}
