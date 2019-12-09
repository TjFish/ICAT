package ICAT.backend.service;

import ICAT.backend.pojo.Adoption;

import ICAT.common.service.CURDService;
import org.springframework.stereotype.Service;

/**
 * @author Shidan Cheng
 * @date 14:18 2019/11/30
 */
@Service
public interface AdoptionService extends CURDService<Adoption, String> {
}
