package ICAT.backend.service.impl;

import ICAT.backend.pojo.Adoption;
import ICAT.backend.dao.repository.AdoptionRepository;
import ICAT.backend.service.AdoptionService;
import ICAT.backend.utils.EntityUtil;
import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shidan Cheng
 * @date 14:22 2019/11/30
 */
@Service
public class AdoptionServiceImpl extends CURDServiceImpl<Adoption, String, AdoptionRepository> implements AdoptionService {
    @Autowired
    AdoptionRepository adoptionRepository;

    @Override
    public List<Adoption> queryAll(){
        return  EntityUtil.castEntity(adoptionRepository.getAllAdoptionsWithCatName(),Adoption.class,new Adoption());
    }
}
