package ICAT.backend.service;

import ICAT.backend.pojo.Postcard;
import ICAT.common.service.CURDService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostcardService extends CURDService<Postcard,String> {
    public List<Postcard> getAllPostcard();

    public List<Integer> getYears();

    public List<Postcard> getAllImageByYear(int year);
}
