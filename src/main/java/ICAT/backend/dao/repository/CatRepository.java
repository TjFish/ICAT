package ICAT.backend.dao.repository;

import ICAT.backend.pojo.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Shidan Cheng
 * @date 11:55 2019/11/30
 */
public interface CatRepository extends JpaRepository<Cat, String> {

    @Query(nativeQuery = true, value = "select * from cat where catColor = :id")
    public List<Cat> getAllCatByCatColor(String id);

}
