package ICAT.backend.dao.repository;

import ICAT.backend.pojo.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;


/**
 * @author: OY
 * @date: 22:17 2019/11/28
 */
public interface SequenceRepository extends JpaRepository<Sequence, Integer> {
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    Sequence getFirstBySeqId(Integer id);
}
