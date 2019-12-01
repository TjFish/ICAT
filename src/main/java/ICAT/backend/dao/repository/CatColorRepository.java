package ICAT.backend.dao.repository;

import ICAT.backend.pojo.CatColor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shidan Cheng
 * @date 12:20 2019/11/30
 */
public interface CatColorRepository extends JpaRepository<CatColor, String> {
}
