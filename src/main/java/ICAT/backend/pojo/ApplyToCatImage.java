package ICAT.backend.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author: OY
 * @date: 10:17 2019/11/27
 */
@Entity
@Table(name = "applyToCatImage")
public class ApplyToCatImage {
    private int applicationId;
    private String imageUrl;
    private Timestamp applicationTime;
    private String auditStatus;

    @Id
    @Column(name = "applicationID")
    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
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
    @Column(name = "applicationTime")
    public Timestamp getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Timestamp applicationTime) {
        this.applicationTime = applicationTime;
    }

    @Basic
    @Column(name = "auditStatus")
    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplyToCatImage that = (ApplyToCatImage) o;

        if (applicationId != that.applicationId) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (applicationTime != null ? !applicationTime.equals(that.applicationTime) : that.applicationTime != null)
            return false;
        if (auditStatus != null ? !auditStatus.equals(that.auditStatus) : that.auditStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = applicationId;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (applicationTime != null ? applicationTime.hashCode() : 0);
        result = 31 * result + (auditStatus != null ? auditStatus.hashCode() : 0);
        return result;
    }
}
