package ICAT.backend.service.impl;

import ICAT.backend.dao.repository.AdoptionRepository;
import ICAT.backend.pojo.Adoption;
import ICAT.backend.pojo.ApplyToAdopt;
import ICAT.backend.dao.repository.ApplyToAdoptRepository;
import ICAT.backend.service.ApplyToAdoptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 14:37 2019/11/30
 */
@Service
@Transactional
@CacheConfig(cacheNames = "ApplyToAdopt")
public class ApplyToAdoptServiceImpl implements ApplyToAdoptService {
    @Autowired
    ApplyToAdoptRepository applyToAdoptRepository;
    @Autowired
    AdoptionRepository adoptionRepository;


    @Override
    @CachePut(key = "#adoption.applicationId")
    public void addApplyToAdopt(ApplyToAdopt adoption) {
        applyToAdoptRepository.saveAndFlush(adoption);

    }

    @Override
    @CacheEvict(key = "#p0")
    public void deleteApplyToAdoptById(String id) {
        applyToAdoptRepository.deleteById(id);

    }

    @Override
    @Cacheable(key = "#adoption.applicationId")
    public void updateApplyToAdopt(ApplyToAdopt adoption) {
        applyToAdoptRepository.saveAndFlush(adoption);
    }

    @Override
    @Cacheable(key = "#id")
    public Optional<ApplyToAdopt> queryApplyToAdoptById(String id) {
        return applyToAdoptRepository.findById(id);
    }

    @Override
    public List<ApplyToAdopt> queryAllApplyToAdopt() {
        return applyToAdoptRepository.findAll();
    }

    @Override
    public boolean existsById(String id) {
        return applyToAdoptRepository.existsById(id);
    }

    @Override
    public boolean auditPassApplyToAdopt(String id) {
        Optional<ApplyToAdopt> check = queryApplyToAdoptById(id);
        if (check.isPresent()) {
            ApplyToAdopt application = check.get();
            Adoption adoption = new Adoption(application);
            adoptionRepository.saveAndFlush(adoption);
            applyToAdoptRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
