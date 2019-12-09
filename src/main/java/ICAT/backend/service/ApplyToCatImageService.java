package ICAT.backend.service;

import ICAT.backend.pojo.ApplyToCatImage;
import ICAT.common.service.CURDService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/**
 * @author Shidan Cheng
 * @date 14:54 2019/11/30
 */

@Service
public interface ApplyToCatImageService extends CURDService<ApplyToCatImage, Integer> {
    public ResponseEntity auditPass(Integer id);
}