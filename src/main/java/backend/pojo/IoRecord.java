package backend.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author: OY
 * @date: 10:18 2019/11/27
 */
@Table(name = "ioRecord")
@Entity
public class IoRecord {
    private String ioId;
    private int amount;
    private Timestamp ioDate;
    private String ioReason;
    private String ioDetail;
    private String ioState;

    @Id
    @Column(name = "ioID")
    public String getIoId() {
        return ioId;
    }

    public void setIoId(String ioId) {
        this.ioId = ioId;
    }

    @Basic
    @Column(name = "Amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "ioDate")
    public Timestamp getIoDate() {
        return ioDate;
    }

    public void setIoDate(Timestamp ioDate) {
        this.ioDate = ioDate;
    }

    @Basic
    @Column(name = "ioReason")
    public String getIoReason() {
        return ioReason;
    }

    public void setIoReason(String ioReason) {
        this.ioReason = ioReason;
    }

    @Basic
    @Column(name = "ioDetail")
    public String getIoDetail() {
        return ioDetail;
    }

    public void setIoDetail(String ioDetail) {
        this.ioDetail = ioDetail;
    }

    @Basic
    @Column(name = "ioState")
    public String getIoState() {
        return ioState;
    }

    public void setIoState(String ioState) {
        this.ioState = ioState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IoRecord ioRecord = (IoRecord) o;

        if (amount != ioRecord.amount) return false;
        if (ioId != null ? !ioId.equals(ioRecord.ioId) : ioRecord.ioId != null) return false;
        if (ioDate != null ? !ioDate.equals(ioRecord.ioDate) : ioRecord.ioDate != null) return false;
        if (ioReason != null ? !ioReason.equals(ioRecord.ioReason) : ioRecord.ioReason != null) return false;
        if (ioDetail != null ? !ioDetail.equals(ioRecord.ioDetail) : ioRecord.ioDetail != null) return false;
        if (ioState != null ? !ioState.equals(ioRecord.ioState) : ioRecord.ioState != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ioId != null ? ioId.hashCode() : 0;
        result = 31 * result + amount;
        result = 31 * result + (ioDate != null ? ioDate.hashCode() : 0);
        result = 31 * result + (ioReason != null ? ioReason.hashCode() : 0);
        result = 31 * result + (ioDetail != null ? ioDetail.hashCode() : 0);
        result = 31 * result + (ioState != null ? ioState.hashCode() : 0);
        return result;
    }
}
