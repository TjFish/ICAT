package ICAT.backend.pojo;

import javax.persistence.*;

/**
 * @author: OY
 * @date: 10:18 2019/11/27
 */
@Table(name = "postcard")
@Entity
public class Postcard {
    private String imageId;
    private int produceYear;
    private String producer;
    private String remark;

    @Id
    @Column(name = "imageID")
    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Basic
    @Column(name = "produceYear")
    public int getProduceYear() {
        return produceYear;
    }

    public void setProduceYear(int produceYear) {
        this.produceYear = produceYear;
    }

    @Basic
    @Column(name = "producer")
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Postcard postcard = (Postcard) o;

        if (produceYear != postcard.produceYear) return false;
        if (imageId != null ? !imageId.equals(postcard.imageId) : postcard.imageId != null) return false;
        if (producer != null ? !producer.equals(postcard.producer) : postcard.producer != null) return false;
        if (remark != null ? !remark.equals(postcard.remark) : postcard.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imageId != null ? imageId.hashCode() : 0;
        result = 31 * result + produceYear;
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
