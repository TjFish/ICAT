package ICAT.backend.dao.mapper;

import ICAT.backend.pojo.Postcard;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;

@Repository
public interface PostcardMapper {
    public List<Postcard> getAllPostcards();

    public Postcard getPostcardById(String id);

    public int updatePostcard(Postcard postcard);

    public int deletePostcard(String id);

    public List<Integer> getYears();

    public List<Postcard> getPostcardByYear(String year);
}
