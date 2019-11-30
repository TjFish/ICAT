package backend.service;

import backend.pojo.Cat;
import backend.pojo.DiseaseRecord;
import backend.pojo.Image;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 11:57 2019/11/30
 */


@Service
public interface CatService {
    public void addCat(Cat cat);

    public void deleteCatById(String id);

    public void updateCat(Cat cat);

    public Optional<Cat> queryCatById(String id);

    public List<Cat> queryAllCat();

    public boolean existsById(String id);

    public List<Image> getAllImageByCatId(String id);

    public List<DiseaseRecord> getAllDiseaseRecordByCatId(String id);

    public List<Cat> getAllCatByCatColor(String id);
}

