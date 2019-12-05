package ICAT.backend.service.impl;

import ICAT.backend.dao.repository.IoRecordsRepository;
import ICAT.backend.pojo.IoRecord;
import ICAT.backend.service.IoRecordsService;
import ICAT.backend.service.SequenceService;
import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IoRecordsServiceImpl extends CURDServiceImpl<IoRecord, String, IoRecordsRepository> implements IoRecordsService {
    @Autowired SequenceService sequenceService;

    @Override
    public IoRecord add(IoRecord ioRecord){
        ioRecord.setIoId(sequenceService.getNextIOId());
        return super.add(ioRecord);
    }
}
