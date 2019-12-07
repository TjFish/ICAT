package ICAT.backend.service.impl;

import ICAT.backend.dao.mapper.ImageMapper;
import ICAT.backend.dao.mapper.PostcardMapper;
import ICAT.backend.pojo.*;
import ICAT.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageMapper imageMapper;

    @Autowired
    SequenceService sequenceService;

    @Autowired
    ApplyToCatImageService applyToCatImageService;

    @Autowired
    ActivityServiceImpl activityServiceImpl;

    @Autowired
    CatImageServiceImpl catImageService;

    @Autowired CatService catService;

    @Autowired
    PostcardMapper postcardMapper;

    @Autowired UserService userService;

    @Autowired AdminService adminService;

    @Override
    public List<Image> getAllImage() {
        return imageMapper.getAllImage();
    }

    @Override
    public Image getImageById(String imageId) {
        return imageMapper.getImageById(imageId);
    }

    @Override
    public Integer updateImage(Image image, String imageId) {
        return imageMapper.updateImage(image);
    }

    @Override
    public Image deleteImage(String imageId) {
        Image deletedImage = imageMapper.getImageById(imageId);
        imageMapper.deleteImage(imageId);
        return deletedImage;
    }

    @Override
    public Image uploadApplyToCatImage(HttpServletRequest req, MultipartFile file, String catId, String userAccount) {
        try {
            String originFileName = file.getOriginalFilename();
            String suffix = originFileName.substring(originFileName.lastIndexOf("."));
            Image newImage = uploadFile(req, file, "Apply",originFileName);
            ApplyToCatImage newApply = new ApplyToCatImage();
            newApply.setApplicationTime(newImage.getPhotoTime());
            newApply.setImageUrl(newImage.getImageUrl());
            newApply.setCatId(catId);
            newApply.setUserAccount(userAccount);
            newApply.setAuditStatus("未审核");

            Integer applyId = applyToCatImageService.addApplyToCatImage(newApply);
            String fileName = "app" + applyId.toString() + suffix;

            newApply.setApplicationId(applyId);
            newApply.setImageUrl("image/Apply/"+fileName);
            applyToCatImageService.updateApplyToCatImage(newApply);
            newImage.setImageId(applyId.toString());
            newImage.setImageUrl("image/Apply/"+fileName);
            return newImage;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Image uploadActivityCover(HttpServletRequest req, MultipartFile file, String activityId) {
        try {
            String originFileName = file.getOriginalFilename();
            String suffix = originFileName.substring(originFileName.lastIndexOf("."));
            String imageID = sequenceService.getNextImageId();
            String fileName = imageID + suffix;
            Image newImage = uploadFile(req, file, "Activity",fileName);
            imageMapper.addImage(newImage);
            Activity newActivity = activityServiceImpl.queryById(activityId);
            newActivity.setActivityCover(newImage.getImageId());
            activityServiceImpl.update(activityId,newActivity);
            return newImage;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Image uploadCatImage(HttpServletRequest req, MultipartFile file, String catId, Integer option) {
        try {
            String originFileName = file.getOriginalFilename();
            String suffix = originFileName.substring(originFileName.lastIndexOf("."));
            String imageID = sequenceService.getNextImageId();
            String fileName = imageID + suffix;
            Image newImage = uploadFile(req, file, "catImage/"+catId,fileName);
            imageMapper.addImage(newImage);
            if(option==1){
                Optional<Cat> newCat = catService.queryCatById(catId);
                if(newCat.isPresent())
                    newCat.get().setHeadPortrait(imageID);
                catService.updateCat(newCat.get());
            }else {
                CatImage newCatImage = new CatImage();
                newCatImage.setCatId(catId);
                newCatImage.setImageId(imageID);
                catImageService.add(newCatImage);
            }
            return newImage;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Postcard uploadPostcard(HttpServletRequest req, MultipartFile file, Integer produceYear) {
        try {
            String originFileName = file.getOriginalFilename();
            String suffix = originFileName.substring(originFileName.lastIndexOf("."));
            String imageID = sequenceService.getNextImageId();
            String fileName = imageID + suffix;
            Image newImage = uploadFile(req, file, "postCard/"+produceYear,fileName);
            imageMapper.addImage(newImage);
            Postcard newPostcard = new Postcard();
            newPostcard.setProduceYear(produceYear);
            newPostcard.setImageId(imageID);
            postcardMapper.addPostcard(newPostcard);
            return newPostcard;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Image uploadUserHead(HttpServletRequest req, MultipartFile file, String userId) {
        try {
            String originFileName = file.getOriginalFilename();
            String suffix = originFileName.substring(originFileName.lastIndexOf("."));
            String imageID = sequenceService.getNextImageId();
            String fileName = imageID + suffix;
            Image newImage = uploadFile(req, file, "UserHead",fileName);
            imageMapper.addImage(newImage);
            Optional<User> newUser = userService.getUserById(userId);
            newUser.get().setHeadPortrait(imageID);
            userService.updateUser(newUser.get());
            return newImage;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Image uploadAdminHead(HttpServletRequest req, MultipartFile file, String adminId) {
        try {
            String originFileName = file.getOriginalFilename();
            String suffix = originFileName.substring(originFileName.lastIndexOf("."));
            String imageID = sequenceService.getNextImageId();
            String fileName = imageID + suffix;
            Image newImage = uploadFile(req, file, "AdminHead",fileName);
            imageMapper.addImage(newImage);
            Optional<Admin> newAdmin = adminService.getAdminById(adminId);
            newAdmin.get().setHeadPortrait(imageID);
            adminService.updateAdmin(newAdmin.get());
            return newImage;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Image uploadFile(HttpServletRequest req, MultipartFile file, String address, String fileName){
        try{
            String destName = req.getServletContext().getRealPath("")+"file"+ File.separator + "image" + File.separator + address + File.separator + fileName;
            File destFile = new File(destName);
            file.transferTo(destFile);

            Image newImage = new Image();
            newImage.setImageId(fileName.substring(0,fileName.lastIndexOf(".")));
            newImage.setImageUrl("image/"+address+"/"+fileName);
            newImage.setPhotoTime(new Timestamp(System.currentTimeMillis()));
            return newImage;
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return null;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
