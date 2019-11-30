package backend.dao.repository;

import backend.pojo.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shidan Cheng
 * @date 14:18 2019/11/30
 */
public interface AdoptionRepository extends JpaRepository<Adoption, String> {
}
