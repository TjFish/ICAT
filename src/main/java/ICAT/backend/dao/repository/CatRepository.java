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

    @Query(nativeQuery = true, value = "select * from cat where catColor = :id order by catID")
    public List<Cat> getAllCatByCatColor(String id);

    @Query(value = "select " +
            "cat.catID as catId, " +
            "cat.catName as catName, " +
            "cat.catColor as catColor, " +
            "cat.catGender as catGender, " +
            "cat.age as age, " +
            "cat.headPortrait as headPortrait, " +
            "cat.isSterilization as isSterilization, " +
            "cat.isAdopt as isAdopt, " +
            "cat.isLost as isLost, " +
            "cat.hint as hint, " +
            "cat.locate as locate, " +
            "cat.characteristics as characteristics, " +
            "cat.appearance as appearance, " +
            "image.imageURL as headImageUrl, " +
            "catColor.colorName as colorName " +
            "from cat left join image on cat.headPortrait = image.imageID left join catColor on cat.catColor = catColor.colorID " +
            "order by length(catId) asc, catId asc", nativeQuery = true)
    public List<Object[]> getCatList();

}
