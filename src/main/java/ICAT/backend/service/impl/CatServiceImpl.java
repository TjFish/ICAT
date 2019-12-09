package ICAT.backend.service.impl;

import ICAT.backend.dao.repository.DiseaseRecordRepository;
import ICAT.backend.pojo.*;
import ICAT.backend.dao.repository.CatRepository;
import ICAT.backend.dao.repository.ImageRepository;
import ICAT.backend.service.CatService;
import ICAT.backend.service.SequenceService;
import ICAT.backend.utils.EntityUtil;
import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shidan Cheng
 * @date 11:59 2019/11/30
 */
@Service
public class CatServiceImpl extends CURDServiceImpl<Cat, String, CatRepository> implements CatService {

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private DiseaseRecordRepository diseaseRecordRepository;

    @Override
    public Cat add(Cat cat) {
        cat.setCatId(sequenceService.getNextCatId());
        return super.add(cat);
    }

    @Override
    public List<Cat> getCatList() {
        return EntityUtil.castEntity(catRepository.getCatList(), Cat.class, new Cat());
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


