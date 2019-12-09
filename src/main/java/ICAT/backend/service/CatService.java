package ICAT.backend.service;

import ICAT.backend.pojo.Cat;
import ICAT.backend.pojo.DiseaseRecord;
import ICAT.backend.pojo.Image;
import ICAT.common.service.CURDService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shidan Cheng
 * @date 11:57 2019/11/30
 */


@Service
public interface CatService extends CURDService<Cat,String> {

    public List<Cat> getCatList();

    public List<Image> getAllImageByCatId(String id);

    public List<DiseaseRecord> getAllDiseaseRecordByCatId(String id);

    public List<Cat> getAllCatByCatColor(String id);

}

