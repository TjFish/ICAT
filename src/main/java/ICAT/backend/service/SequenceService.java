package ICAT.backend.service;

import org.springframework.stereotype.Service;

/**
 * @author: OY
 * @date: 22:11 2019/11/28
 */
@Service
public interface SequenceService {

    String getNextCatId();
    String getNextIOId();
    String getNextImageId();
    String getNextDiseaseRecordId();
    String getNextActivityId();
}
