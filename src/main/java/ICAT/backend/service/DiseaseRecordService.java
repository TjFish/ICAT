package ICAT.backend.service;

import ICAT.backend.pojo.DiseaseRecord;
import ICAT.common.service.CURDService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: OY
 * @date: 18:24 2019/11/28
 */
@Service
public interface DiseaseRecordService extends CURDService<DiseaseRecord,String> {

}
