package ICAT.backend.dao.repository;

import ICAT.backend.pojo.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Shidan Cheng
 * @date 16:03 2019/11/30
 */
public interface ImageRepository extends JpaRepository<Image, String> {
    @Query(nativeQuery = true, value = "select * from image i where i.imageId in (select t.imageId from catImage t where t.catId = :id)")
    public List<Image> getAllImageByCatId(String id);
}
