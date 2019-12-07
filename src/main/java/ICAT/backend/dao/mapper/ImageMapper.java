package ICAT.backend.dao.mapper;

import ICAT.backend.pojo.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageMapper {
    public List<Image> getAllImage();

    public Image getImageById(String id);

    public int updateImage(Image image);

    public int deleteImage(String id);

    public int addImage(Image image);
}
