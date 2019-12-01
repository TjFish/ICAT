package ICAT.backend.pojo;

import javax.persistence.*;

/**
 * @author: OY
 * @date: 22:04 2019/11/28
 */
@Entity
@Table(name = "sequence")
public class Sequence {
    private Long catSeq;
    private Long activitySeq;
    private Long imageSeq;
    private Long ioSeq;
    private Long diseaseSeq;
    private Integer seqId;

    @Basic
    @Column(name = "CAT_SEQ")
    public Long getCatSeq() {
        return catSeq;
    }

    public void setCatSeq(Long catSeq) {
        this.catSeq = catSeq;
    }

    @Basic
    @Column(name = "ACTIVITY_SEQ")
    public Long getActivitySeq() {
        return activitySeq;
    }

    public void setActivitySeq(Long activitySeq) {
        this.activitySeq = activitySeq;
    }

    @Basic
    @Column(name = "IMAGE_SEQ")
    public Long getImageSeq() {
        return imageSeq;
    }

    public void setImageSeq(Long imageSeq) {
        this.imageSeq = imageSeq;
    }

    @Basic
    @Column(name = "IO_SEQ")
    public Long getIoSeq() {
        return ioSeq;
    }

    public void setIoSeq(Long ioSeq) {
        this.ioSeq = ioSeq;
    }



    @Basic
    @Column(name = "DISEASE_SEQ")
    public Long getDiseaseSeq() {
        return diseaseSeq;
    }

    public void setDiseaseSeq(Long diseaseSeq) {
        this.diseaseSeq = diseaseSeq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sequence sequence = (Sequence) o;

        if (catSeq != null ? !catSeq.equals(sequence.catSeq) : sequence.catSeq != null) return false;
        if (activitySeq != null ? !activitySeq.equals(sequence.activitySeq) : sequence.activitySeq != null)
            return false;
        if (imageSeq != null ? !imageSeq.equals(sequence.imageSeq) : sequence.imageSeq != null) return false;
        if (ioSeq != null ? !ioSeq.equals(sequence.ioSeq) : sequence.ioSeq != null) return false;
        if (diseaseSeq != null ? !diseaseSeq.equals(sequence.diseaseSeq) : sequence.diseaseSeq != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catSeq != null ? catSeq.hashCode() : 0;
        result = 31 * result + (activitySeq != null ? activitySeq.hashCode() : 0);
        result = 31 * result + (imageSeq != null ? imageSeq.hashCode() : 0);
        result = 31 * result + (ioSeq != null ? ioSeq.hashCode() : 0);

        result = 31 * result + (diseaseSeq != null ? diseaseSeq.hashCode() : 0);
        return result;
    }


    @Id
    @Column(name = "seqId")
    public Integer getSeqId() {
        return seqId;
    }

    public void setSeqId(Integer seqId) {
        this.seqId = seqId;
    }
}
