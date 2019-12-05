package ICAT.backend.service;

import ICAT.backend.pojo.IoRecord;
import ICAT.common.service.CURDService;
import org.springframework.stereotype.Service;


@Service
public interface IoRecordsService  extends CURDService<IoRecord,String> {

}
