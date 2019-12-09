package ICAT.backend.service.impl;

import ICAT.backend.pojo.Adoption;
import ICAT.backend.dao.repository.AdoptionRepository;
import ICAT.backend.service.AdoptionService;
import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Shidan Cheng
 * @date 14:22 2019/11/30
 */
@Service
public class AdoptionServiceImpl extends CURDServiceImpl<Adoption, String, AdoptionRepository> implements AdoptionService {
}
