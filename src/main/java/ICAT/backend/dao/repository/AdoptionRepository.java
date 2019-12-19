package ICAT.backend.dao.repository;

import ICAT.backend.pojo.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Shidan Cheng
 * @date 14:18 2019/11/30
 */
public interface AdoptionRepository extends JpaRepository<Adoption, String> {
    @Query(nativeQuery = true, value =
            "select " +"adoption.catID as catId,"+
                    " adoption.userAccount as userAccount," +
                    " adoption.adoptTime as adoptTime," +
                    " adoption.userName as userName," +
                    " adoption.userPhone as userPhone," +
                    " adoption.userAddress as userAddress," +
                    " adoption.userGender as userGender," +
                    " cat.catName as catName"+
                    " from adoption " +
                    "join cat on adoption.catID = cat.catID")
    public List<Object[]> getAllAdoptionsWithCatName();
}
