package backend.service;

import backend.pojo.DiseaseRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: OY
 * @date: 18:24 2019/11/28
 */
@Service
public interface DiseaseRecordService {
    public void addDiseaseRecord(DiseaseRecord one);

    public void deleteDiseaseRecordById(String id);

    public void updateDiseaseRecord(DiseaseRecord one);

    public Optional<DiseaseRecord> queryDiseaseRecordById(String id);

    public List<DiseaseRecord> queryAllDiseaseRecord();
}
