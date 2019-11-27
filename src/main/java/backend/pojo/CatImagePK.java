package backend.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author: OY
 * @date: 10:17 2019/11/27
 */
public class CatImagePK implements Serializable {
    private String imageId;
    private String catId;

    @Column(name = "imageID")
    @Id
    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Column(name = "catID")
    @Id
    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatImagePK that = (CatImagePK) o;

        if (imageId != null ? !imageId.equals(that.imageId) : that.imageId != null) return false;
        if (catId != null ? !catId.equals(that.catId) : that.catId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imageId != null ? imageId.hashCode() : 0;
        result = 31 * result + (catId != null ? catId.hashCode() : 0);
        return result;
    }
}
