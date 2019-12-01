package backend.service;

import backend.pojo.CatColor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * @author Shidan Cheng
 * @date 12:20 2019/11/30
 */

@Service
public interface CatColorService {
    public void addCatColor(CatColor catColor);

    public void deleteCatColorById(String id);

    public void updateCatColor(CatColor catColor);

    public Optional<CatColor> queryCatColorById(String id);

    public List<CatColor> queryAllCatColor();

    public boolean existsById(String id);
}


