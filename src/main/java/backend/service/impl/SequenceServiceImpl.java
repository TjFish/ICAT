package backend.service.impl;

import backend.dao.repository.SequenceRepository;
import backend.pojo.Sequence;
import backend.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;

/**
 * @author: OY
 * @date: 22:16 2019/11/28
 */
@Service
@Transactional
public class SequenceServiceImpl implements SequenceService {
    @Autowired
    SequenceRepository sequenceRepository;
    @Override
    public String getNextCatId() {
        Sequence sequence=sequenceRepository.getFirstBySeqId(0);
        Long seq=sequence.getCatSeq()+1;
        sequence.setCatSeq(seq);
        sequenceRepository.save(sequence);
        return "cat"+seq.toString();
    }

    @Override
    public String getNextIOId() {
        Sequence sequence=sequenceRepository.getFirstBySeqId(0);
        Long seq=sequence.getIoSeq()+1;
        sequence.setIoSeq(seq);
        sequenceRepository.save(sequence);
        return "io"+seq.toString();
    }

    @Override
    public String getNextImageId() {
        Sequence sequence=sequenceRepository.getFirstBySeqId(0);
        Long seq=sequence.getImageSeq()+1;
        sequence.setImageSeq(seq);
        sequenceRepository.save(sequence);
        return "img"+seq.toString();
    }

    @Override
    public String getNextDiseaseRecordId() {
        Sequence sequence=sequenceRepository.getFirstBySeqId(0);
        Long seq=sequence.getDiseaseSeq()+1;
        sequence.setDiseaseSeq(seq);
        sequenceRepository.save(sequence);
        return "ill"+seq.toString();
    }

    @Override
    public String getNextActivityId() {
        Sequence sequence=sequenceRepository.getFirstBySeqId(0);
        Long seq=sequence.getActivitySeq()+1;
        sequence.setActivitySeq(seq);
        sequenceRepository.save(sequence);
        return "act"+seq.toString();
    }
}
