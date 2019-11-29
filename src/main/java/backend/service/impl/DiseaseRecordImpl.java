package backend.service.impl;

import backend.dao.repository.DiseaseRecordRepository;
import backend.pojo.DiseaseRecord;
import backend.service.DiseaseRecordService;
import backend.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author: OY
 * @date: 19:01 2019/11/28
 */

@Service
public class DiseaseRecordImpl implements DiseaseRecordService {
    @Autowired
    DiseaseRecordRepository diseaseRecordRepository;
    @Autowired
    SequenceService sequenceService;
    @Transactional
    @Override
    public void addDiseaseRecord(DiseaseRecord one) {
        one.setRecordId(sequenceService.getNextDiseaseRecordId());
        diseaseRecordRepository.saveAndFlush(one);
    }
    @Transactional
    @Override
    public void deleteDiseaseRecordById(String id) {
        diseaseRecordRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateDiseaseRecord(DiseaseRecord one) {
        diseaseRecordRepository.saveAndFlush(one);
    }

    @Override
    public Optional<DiseaseRecord> queryDiseaseRecordById(String id) {
        return diseaseRecordRepository.findById(id);
    }

    @Override
    public List<DiseaseRecord> queryAllDiseaseRecord() {
        return diseaseRecordRepository.findAll();
    }
}
