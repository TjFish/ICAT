package ICAT.backend.service;

import ICAT.backend.pojo.CatImage;
import ICAT.common.service.CURDService;
import org.springframework.stereotype.Service;

@Service
public interface CatImageService extends CURDService<CatImage,String> {

}
