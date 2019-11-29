package backend.dao.repository;

import backend.pojo.DiseaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: OY
 * @date: 18:58 2019/11/28
 */
public interface DiseaseRecordRepository extends JpaRepository<DiseaseRecord,String> {
}
