package backend.dao.repository;

import backend.pojo.ApplyToAdopt;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shidan Cheng
 * @date 14:35 2019/11/30
 */
public interface ApplyToAdoptRepository extends JpaRepository<ApplyToAdopt, String> {
}
