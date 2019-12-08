package ICAT.backend.service;

import ICAT.backend.pojo.Image;
import ICAT.backend.pojo.Postcard;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ImageService {
    public List<Image> getAllImage();

    public Image getImageById(String imageId);

    public Integer updateImage(Image image, String imageId);

    public Image deleteImage(String imageId);

    public Image uploadApplyToCatImage(HttpServletRequest req, MultipartFile file, String catId, String userAccount);

    public Image uploadActivityCover(HttpServletRequest req, MultipartFile file, String activityId);

    public Image uploadCatImage(HttpServletRequest req, MultipartFile file, String catId, Integer option);

    public Postcard uploadPostcard(HttpServletRequest req, MultipartFile file, Integer produceYear);

    public Image uploadUserHead(HttpServletRequest req, MultipartFile file, String userId);

    public Image uploadAdminHead(HttpServletRequest req, MultipartFile file, String adminId);
}
