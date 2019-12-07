package ICAT.backend.service.impl;

import ICAT.backend.pojo.ApplyToCatImage;
import ICAT.backend.dao.repository.ApplyToCatImageRepository;
import ICAT.backend.service.ApplyToCatImageService;
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
 * @date 14:55 2019/11/30
 */
@Service
@Transactional
@CacheConfig(cacheNames = "ApplyToCatImage")
public class ApplyToCatImageServiceImpl implements ApplyToCatImageService {
    @Autowired
    ApplyToCatImageRepository applyToCatImageRepository;


    @Override
    @CachePut(key = "#adoption.applicationId")
    public Integer addApplyToCatImage(ApplyToCatImage adoption) {
        ApplyToCatImage newApply =  applyToCatImageRepository.saveAndFlush(adoption);
        return newApply.getApplicationId();
    }

    @Override
    @CacheEvict(key = "#p0")
    public void deleteApplyToCatImageById(String id) {
        applyToCatImageRepository.deleteById(id);

    }

    @Override
    @Cacheable(key = "#adoption.applicationId")
    public void updateApplyToCatImage(ApplyToCatImage adoption) {
        applyToCatImageRepository.saveAndFlush(adoption);
    }

    @Override
    @Cacheable(key = "#id")
    public Optional<ApplyToCatImage> queryApplyToCatImageById(String id) {
        return applyToCatImageRepository.findById(id);
    }

    @Override
    public List<ApplyToCatImage> queryAllApplyToCatImage() {
        return applyToCatImageRepository.findAll();
    }

    @Override
    public boolean existsById(String id) {
        return applyToCatImageRepository.existsById(id);
    }
}

