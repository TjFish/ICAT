package ICAT.backend.service;

import ICAT.backend.pojo.ApplyToAdopt;
import ICAT.common.service.CURDService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Shidan Cheng
 * @date 14:36 2019/11/30
 */
@Service
public interface ApplyToAdoptService extends CURDService<ApplyToAdopt, Integer> {
    public ResponseEntity auditPass(Integer id);
}
