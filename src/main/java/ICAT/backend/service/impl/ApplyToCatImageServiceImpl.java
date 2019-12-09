package ICAT.backend.service.impl;


import ICAT.backend.dao.repository.CatRepository;

import ICAT.backend.dao.repository.ImageRepository;
import ICAT.backend.pojo.ApplyToCatImage;
import ICAT.backend.dao.repository.ApplyToCatImageRepository;
import ICAT.backend.pojo.Cat;
import ICAT.backend.pojo.Image;
import ICAT.backend.service.ApplyToCatImageService;
import ICAT.backend.utils.EntityUtil;
import ICAT.common.service.Impl.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 14:55 2019/11/30
 */
@Service
@CacheConfig(cacheNames = "ApplyToCatImage")
public class ApplyToCatImageServiceImpl extends CURDServiceImpl<ApplyToCatImage, Integer, ApplyToCatImageRepository> implements ApplyToCatImageService {
    @Autowired
    ApplyToCatImageRepository applyToCatImageRepository;
    @Autowired
    CatRepository catRepository;
    @Autowired
    ImageRepository imageRepository;

    @Override
    public List<ApplyToCatImage> queryAll() {
        return EntityUtil.castEntity(applyToCatImageRepository.findAllWithAppendInfo(), ApplyToCatImage.class, new ApplyToCatImage());
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity auditPass(Integer id) {
        ApplyToCatImage apply = null;
        Cat cat = null;
        Optional<ApplyToCatImage> applyCheck = applyToCatImageRepository.findById(id);
        if (applyCheck.isPresent()) {
            apply = applyCheck.get();
        } else {
            return new ResponseEntity("未找到指定ID", HttpStatus.NOT_FOUND);
        }
        apply.setAuditStatus("审核通过");
        if (!catRepository.findById(apply.getCatId()).isPresent()) {
            return new ResponseEntity("无指定猫咪", HttpStatus.NOT_FOUND);
        }

        Image image = new Image();
        image.setImageId("default");
        image.setImageUrl("default");
        image.setPhotoTime(new Timestamp(System.currentTimeMillis()));
        image = imageRepository.saveAndFlush(image);

        String originPath = "../file/" + apply.getImageUrl();
        String catId = apply.getCatId();
        String category = "catImage/" + catId;
        String imageId = image.getImageId();
        String fileDir = "../file/image/" + category;
        File directory = new File(fileDir);
        if (!directory.exists() && !directory.isDirectory()) {
            if (!directory.mkdir()){
                return new ResponseEntity("服务器内部错误", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        String extension = originPath.substring(originPath.lastIndexOf('.') + 1);
        String fileName = imageId + extension.toLowerCase();
        String targetPath = fileDir + "/" + fileName;

        File origin = new File(originPath);
        File target = new File(targetPath);
        try {
            origin.renameTo(target);
            String imageUrl = "image/" + category + "/" + fileName;
            image.setImageUrl(imageUrl);
            imageRepository.saveAndFlush(image);
            applyToCatImageRepository.delete(apply);
        } catch (Exception e) {
            return new ResponseEntity("服务器内部错误", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(image, HttpStatus.OK);
    }
}

