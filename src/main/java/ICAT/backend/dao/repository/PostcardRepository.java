package ICAT.backend.dao.repository;

import ICAT.backend.pojo.Image;
import ICAT.backend.pojo.Postcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Year;
import java.util.List;

/**
 * @author Hongguang Zhou
 * @date 21:35 2019/12/5
 */
public interface PostcardRepository extends JpaRepository<Postcard,String> {
    @Query(nativeQuery = true, value = "select postcard.imageID, postcard.produceYear, postcard.producer, postcard.remark," +
            "image.imageURL from postcard natural join image")
    public List<Postcard> getAllPostcard();

    @Query(nativeQuery = true, value = "select distinct(postcard.year) from postcard")
    public List<Integer> getYears();

    @Query(nativeQuery = true, value = "select * from postcard i where produceYear = :year")
    public List<Postcard> getAllImageByYear(int year);
}
