package backend.service.impl;

import backend.dao.repository.AdoptionRepository;
import backend.pojo.Adoption;
import backend.service.AdoptionService;
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
 * @date 14:22 2019/11/30
 */
@Service
@Transactional
@CacheConfig(cacheNames = "Adoption")
public class AdoptionServiceImpl implements AdoptionService {
    @Autowired
    private AdoptionRepository adoptionRepository;


    @Override
    @CachePut(key = "#adoption.catId")
    public void addAdoption(Adoption adoption) {
        adoptionRepository.saveAndFlush(adoption);

    }

    @Override
    @CacheEvict(key = "#p0")
    public void deleteAdoptionById(String id) {
        adoptionRepository.deleteById(id);
    }

    @Override
    @CachePut(key = "#adoption.catId")
    public void updateAdoption(Adoption adoption) {
        adoptionRepository.saveAndFlush(adoption);

    }

    @Override
    @Cacheable(key = "#id")
    public Optional<Adoption> queryAdoptionById(String id) {
        return adoptionRepository.findById(id);
    }

    @Override
    public List<Adoption> queryAllAdoption() {
        return adoptionRepository.findAll();
    }

    @Override
    public boolean existsById(String id) {
        return adoptionRepository.existsById(id);
    }
}
