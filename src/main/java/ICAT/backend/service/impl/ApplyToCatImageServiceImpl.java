package ICAT.backend.service.impl;

import ICAT.backend.pojo.ApplyToCatImage;
import ICAT.backend.dao.repository.ApplyToCatImageRepository;
import ICAT.backend.pojo.Image;
import ICAT.backend.service.ApplyToCatImageService;
import ICAT.backend.service.ImageService;
import ICAT.backend.utils.ImageBase64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 14:55 2019/11/30
 */
@Service
@Transactional
@CacheConfig(cacheNames = "ApplyToCatImage")
public class ApplyToCatImageServiceImpl implements ApplyToCatImageService {
    @Autowired
    ApplyToCatImageRepository applyToCatImageRepository;

    @Autowired
    ImageService imageService;

    @Override
    @CachePut(key = "#adoption.applicationId")
    public Integer addApplyToCatImage(ApplyToCatImage adoption) {
        ApplyToCatImage newApply = applyToCatImageRepository.saveAndFlush(adoption);
        return newApply.getApplicationId();
    }

    @Override
    @CacheEvict(key = "#p0")
    public void deleteApplyToCatImageById(String id) {
        applyToCatImageRepository.deleteById(id);

    }

    @Override
    @Cacheable(key = "#adoption.applicationId")
    public void updateApplyToCatImage(ApplyToCatImage adoption) {
        applyToCatImageRepository.saveAndFlush(adoption);
    }

    @Override
    @Cacheable(key = "#id")
    public Optional<ApplyToCatImage> queryApplyToCatImageById(String id) {
        return applyToCatImageRepository.findById(id);
    }

    @Override
    public List<ApplyToCatImage> queryAllApplyToCatImage() {
        return applyToCatImageRepository.findAll();
    }

    @Override
    public boolean existsById(String id) {
        return applyToCatImageRepository.existsById(id);
    }

    @Override
    public Image auditPassApplyToCatImage(HttpServletRequest request, String id) {
        Optional<ApplyToCatImage> check = applyToCatImageRepository.findById(id);
        if (check.isPresent()) {
            try {
                ApplyToCatImage application = check.get();
                String image = ImageBase64Util.imageToBase64(application.getImageUrl());
                MultipartFile file = ImageBase64Util.base64ToMultipart(image);
                Image result = imageService.uploadCatImage(request, file, application.getCatId(), 0);
                result.setPhotoTime(application.getApplicationTime());
                imageService.updateImage(result,result.getImageId());
                applyToCatImageRepository.deleteById(id);
                return result;
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }
}

