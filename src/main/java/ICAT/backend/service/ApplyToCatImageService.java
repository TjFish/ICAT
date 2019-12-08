package ICAT.backend.service;

import ICAT.backend.pojo.ApplyToCatImage;
import ICAT.backend.pojo.Image;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 14:54 2019/11/30
 */

@Service
public interface ApplyToCatImageService {
    public Integer addApplyToCatImage(ApplyToCatImage application);

    public void deleteApplyToCatImageById(String id);

    public void updateApplyToCatImage(ApplyToCatImage application);

    public Optional<ApplyToCatImage> queryApplyToCatImageById(String id);

    public List<ApplyToCatImage> queryAllApplyToCatImage();

    public boolean existsById(String id);

    public Image auditPassApplyToCatImage(HttpServletRequest request, String id);
}