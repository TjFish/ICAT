package backend.service.impl;

import backend.dao.repository.DiseaseRecordRepository;
import backend.pojo.DiseaseRecord;
import backend.service.DiseaseRecordService;
import backend.service.SequenceService;
import common.service.Impl.CURDServiceImpl;
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
public class DiseaseRecordImpl extends CURDServiceImpl<DiseaseRecord,String,DiseaseRecordRepository> implements DiseaseRecordService  {

}
