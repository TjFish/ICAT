package backend.dao.repository;

import backend.pojo.CatColor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shidan Cheng
 * @date 12:20 2019/11/30
 */
public interface CatColorRepository extends JpaRepository<CatColor, String> {
}
