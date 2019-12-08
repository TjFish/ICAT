package ICAT.backend.service.impl;

import ICAT.backend.pojo.CatColor;
import ICAT.backend.dao.repository.CatColorRepository;
import ICAT.backend.service.CatColorService;
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
 * @date 12:20 2019/11/30
 */
@Service
@Transactional
@CacheConfig(cacheNames = "CatColor")
public class CatColorServiceImpl implements CatColorService {
    @Autowired
    private CatColorRepository catColorRepository;

    @Override
    @CachePut(key = "#catColor.colorId")
    public void addCatColor(CatColor catColor) {
        catColorRepository.saveAndFlush(catColor);
    }

    @Override
    @CacheEvict(key = "#p0")
    public void deleteCatColorById(String id) {
        catColorRepository.deleteById(id);
    }

    @Override
    @CachePut(key = "catColor.colorId")
    public void updateCatColor(CatColor catColor) {
        catColorRepository.saveAndFlush(catColor);
    }

    @Override
    @Cacheable(key = "#id")
    public Optional<CatColor> queryCatColorById(String id) {
        return catColorRepository.findById(id);
    }

    @Override
    public List<CatColor> queryAllCatColor() {
        return catColorRepository.findAll();
    }

    @Override
    public boolean existsById(String id) {
        return catColorRepository.existsById(id);
    }
}
