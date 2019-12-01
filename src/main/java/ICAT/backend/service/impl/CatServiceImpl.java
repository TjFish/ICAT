package ICAT.backend.service.impl;

import ICAT.backend.dao.repository.DiseaseRecordRepository;
import ICAT.backend.pojo.Cat;
import ICAT.backend.pojo.DiseaseRecord;
import ICAT.backend.pojo.Image;
import ICAT.backend.dao.repository.CatRepository;
import ICAT.backend.dao.repository.ImageRepository;
import ICAT.backend.service.CatService;
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
 * @date 11:59 2019/11/30
 */
@Service
@Transactional
@CacheConfig(cacheNames = "Cat")
public class CatServiceImpl implements CatService {
    @Autowired
    private CatRepository catRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private DiseaseRecordRepository diseaseRecordRepository;

    @Override
    @CachePut(key = "#cat.catId")
    public void addCat(Cat cat) {
        catRepository.saveAndFlush(cat);
    }

    @Override
    @CacheEvict(key = "#p0")
    public void deleteCatById(String id) {
        catRepository.deleteById(id);
    }

    @Override
    @CachePut(key = "#cat.catId")
    public void updateCat(Cat cat) {
        catRepository.saveAndFlush(cat);
    }

    @Override
    @Cacheable(key = "#id")
    public Optional<Cat> queryCatById(String id) {
        return catRepository.findById(id);
    }

    @Override
    public List<Cat> queryAllCat() {
        return catRepository.findAll();
    }

    @Override
    public boolean existsById(String id) {
        return catRepository.existsById(id);
    }

    @Override
    public List<Image> getAllImageByCatId(String id) {
        return imageRepository.getAllImageByCatId(id);
    }

    @Override
    public List<DiseaseRecord> getAllDiseaseRecordByCatId(String id) {
        return diseaseRecordRepository.getAllDiseaseRecordByCatId(id);
    }

    @Override
    public List<Cat> getAllCatByCatColor(String id) {
        return catRepository.getAllCatByCatColor(id);
    }
}


