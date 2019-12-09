package ICAT.backend.dao.repository;

import ICAT.backend.pojo.ApplyToCatImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Shidan Cheng
 * @date 14:53 2019/11/30
 */
public interface ApplyToCatImageRepository extends JpaRepository<ApplyToCatImage, Integer> {

    @Query(nativeQuery = true, value = "select s.applicationID as applicationId, s.imageURL as imageUrl,  s.catID as catId, s.applicationTime as applicationTime, s.auditStatus as auditStatus, s.userAccount as userAccount, c.catName as catName  from applyToCatImage s , cat c where s.catID = c.catID")
    List<Object[]> findAllWithAppendInfo();
}
