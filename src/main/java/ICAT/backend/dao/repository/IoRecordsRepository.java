package ICAT.backend.dao.repository;

import ICAT.backend.pojo.Image;
import ICAT.backend.pojo.IoRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hongguang Zhou
 * @date 20:12 2019/12/5
 */
public interface IoRecordsRepository extends JpaRepository<IoRecord, String> {

}
