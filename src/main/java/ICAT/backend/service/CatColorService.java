package ICAT.backend.service;

import ICAT.backend.pojo.CatColor;
import ICAT.common.service.CURDService;
import org.springframework.stereotype.Service;



/**
 * @author Shidan Cheng
 * @date 12:20 2019/11/30
 */

@Service
public interface CatColorService extends CURDService<CatColor, String> {
}


