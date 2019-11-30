package backend.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author: OY
 * @date: 10:17 2019/11/27
 */
@Table(name = "image")
@Entity
public class Image {
    private String imageId;
    private String imageUrl;
    private Timestamp photoTime;

    @Id
    @Column(name = "imageID")
    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Basic
    @Column(name = "imageURL")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "photoTime")
    public Timestamp getPhotoTime() {
        return photoTime;
    }

    public void setPhotoTime(Timestamp photoTime) {
        this.photoTime = photoTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (imageId != null ? !imageId.equals(image.imageId) : image.imageId != null) return false;
        if (imageUrl != null ? !imageUrl.equals(image.imageUrl) : image.imageUrl != null) return false;
        if (photoTime != null ? !photoTime.equals(image.photoTime) : image.photoTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imageId != null ? imageId.hashCode() : 0;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (photoTime != null ? photoTime.hashCode() : 0);
        return result;
    }


    public String formattedOutput() {
        return "[imageId]: " + imageId
                + "\t | \t[imageUrl]: " + imageUrl
                + "\t | \t[photoTime]: " + photoTime
                + "\n";
    }
}
