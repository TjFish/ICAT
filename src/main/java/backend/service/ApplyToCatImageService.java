package backend.service;

import backend.pojo.ApplyToCatImage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 14:54 2019/11/30
 */

@Service
public interface ApplyToCatImageService {
    public void addApplyToCatImage(ApplyToCatImage application);

    public void deleteApplyToCatImageById(String id);

    public void updateApplyToCatImage(ApplyToCatImage application);

    public Optional<ApplyToCatImage> queryApplyToCatImageById(String id);

    public List<ApplyToCatImage> queryAllApplyToCatImage();

    public boolean existsById(String id);
}