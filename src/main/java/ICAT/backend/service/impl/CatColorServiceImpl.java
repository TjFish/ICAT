package ICAT.backend.service.impl;

import ICAT.backend.pojo.CatColor;
import ICAT.backend.dao.repository.CatColorRepository;
import ICAT.backend.service.CatColorService;

import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Shidan Cheng
 * @date 12:20 2019/11/30
 */
@Service
public class CatColorServiceImpl extends CURDServiceImpl<CatColor, String, CatColorRepository>  implements CatColorService{
}
