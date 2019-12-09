package ICAT.backend.service.impl;

import ICAT.backend.dao.repository.AdoptionRepository;
import ICAT.backend.dao.repository.CatRepository;
import ICAT.backend.pojo.Adoption;
import ICAT.backend.pojo.ApplyToAdopt;
import ICAT.backend.dao.repository.ApplyToAdoptRepository;
import ICAT.backend.pojo.Cat;
import ICAT.backend.service.ApplyToAdoptService;
import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 14:37 2019/11/30
 */
@Service
public class ApplyToAdoptServiceImpl extends CURDServiceImpl<ApplyToAdopt, Integer, ApplyToAdoptRepository> implements ApplyToAdoptService {
    @Autowired
    ApplyToAdoptRepository applyToAdoptRepository;
    @Autowired
    CatRepository catRepository;
    @Autowired
    AdoptionRepository adoptionRepository;

    @Override
    @Transactional
    public ResponseEntity auditPass(Integer id) {
        ApplyToAdopt apply = null;
        Cat cat = null;
        Optional<ApplyToAdopt> applyCheck = applyToAdoptRepository.findById(id);
        if (applyCheck.isPresent()) {
            apply = applyCheck.get();
        } else {
            return new ResponseEntity("无指定ID", HttpStatus.NOT_FOUND);
        }
        Optional<Cat> catCheck = catRepository.findById(apply.getCatId());
        if (catCheck.isPresent()) {
            cat = catCheck.get();
        } else {
            return new ResponseEntity("无指定猫咪", HttpStatus.NOT_FOUND);
        }
        apply.setAuditStatus("审核通过");
        cat.setIsAdopt(true);
        applyToAdoptRepository.saveAndFlush(apply);
        catRepository.saveAndFlush(cat);
        adoptionRepository.saveAndFlush(new Adoption(apply));

        return new ResponseEntity(HttpStatus.OK);
    }
}
