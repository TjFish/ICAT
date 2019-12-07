package ICAT.backend.service;

import ICAT.backend.pojo.Postcard;
import ICAT.common.service.CURDService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostcardService {
    public List<Postcard> getAllPostcards();

    public Postcard getPostcardById(String id);

    public int updatePostcard(Postcard postcard);

    public int deletePostcard(String id);

    public List<Integer> getYears();

    public List<Postcard> getPostcardByYear(Integer year);
}
