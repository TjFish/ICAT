package ICAT.backend.service.impl;

import ICAT.backend.dao.repository.CatImageRepository;
import ICAT.backend.pojo.CatImage;
import ICAT.backend.service.CatImageService;
import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CatImageServiceImpl extends CURDServiceImpl<CatImage,String, CatImageRepository> {

}
