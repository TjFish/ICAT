package ICAT.backend.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author: OY
 * @date: 10:23 2019/11/27
 */
@Table(name = "diseaseRecord")
@Entity
public class DiseaseRecord {
    private String recordId;
    private String diseaseName;
    private Timestamp startTime;
    private Timestamp endTime;
    private String remark;
    private String catId;
    //@JsonIgnore
    //private Cat cat;

    @Id
    @Column(name = "recordID")
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "catID")
    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    @Basic
    @Column(name = "diseaseName")
    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Basic
    @Column(name = "startTime")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endTime")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "catID")
//    public Cat getCat() {
//        return cat;
//    }
//
//    public void setCat(Cat cat) {
//        this.cat = cat;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiseaseRecord that = (DiseaseRecord) o;

        if (recordId != null ? !recordId.equals(that.recordId) : that.recordId != null) return false;
        if (diseaseName != null ? !diseaseName.equals(that.diseaseName) : that.diseaseName != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordId != null ? recordId.hashCode() : 0;
        result = 31 * result + (diseaseName != null ? diseaseName.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
