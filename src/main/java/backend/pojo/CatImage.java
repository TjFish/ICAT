package backend.pojo;

import javax.persistence.*;

/**
 * @author: OY
 * @date: 10:17 2019/11/27
 */
@Entity
@Table(name = "catImage")
@IdClass(CatImagePK.class)
public class CatImage {
    private String imageId;
    private String catId;

    @Id
    @Column(name = "imageID")
    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Id
    @Column(name = "catID")
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

        CatImage catImage = (CatImage) o;

        if (imageId != null ? !imageId.equals(catImage.imageId) : catImage.imageId != null) return false;
        if (catId != null ? !catId.equals(catImage.catId) : catImage.catId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imageId != null ? imageId.hashCode() : 0;
        result = 31 * result + (catId != null ? catId.hashCode() : 0);
        return result;
    }
}
