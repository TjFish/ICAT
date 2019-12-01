package backend.service;

import backend.pojo.DiseaseRecord;
import common.service.CURDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: OY
 * @date: 18:24 2019/11/28
 */
@Service
public interface DiseaseRecordService extends CURDService<DiseaseRecord,String> {

}
