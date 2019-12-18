package ICAT.backend.service.impl;

import ICAT.backend.pojo.Cat;
import ICAT.backend.pojo.DiseaseRecord;
import ICAT.backend.dao.repository.DiseaseRecordRepository;
import ICAT.backend.service.DiseaseRecordService;
import ICAT.backend.service.SequenceService;
import ICAT.backend.utils.EntityUtil;
import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: OY
 * @date: 19:01 2019/11/28
 */

@Service
public class DiseaseRecordImpl extends CURDServiceImpl<DiseaseRecord,String,DiseaseRecordRepository> implements DiseaseRecordService  {
    @Autowired
    SequenceService sequenceService;

    @Autowired
    DiseaseRecordRepository diseaseRecordRepository;

    @Override
    public DiseaseRecord add(DiseaseRecord diseaseRecord) {
        diseaseRecord.setRecordId(sequenceService.getNextDiseaseRecordId());
        return super.add(diseaseRecord);
    }

    @Override
    public List<DiseaseRecord> queryAll() {
        return EntityUtil.castEntity(diseaseRecordRepository.getAllDiseaseRecordsWithCatName(),DiseaseRecord.class,new DiseaseRecord());
    }
}
