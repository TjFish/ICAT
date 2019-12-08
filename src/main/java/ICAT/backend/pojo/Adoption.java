package ICAT.backend.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: OY
 * @date: 10:17 2019/11/27
 */
@Entity
@Table(name = "adoption")
public class Adoption {
    private String catId;
    private Timestamp adoptTime;
    private String userName;
    private String userPhone;
    private String userAddress;
    private String userGender;

    @Id
    @Column(name = "catID")
    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    @Basic
    @Column(name = "adoptTime")
    public Timestamp getAdoptTime() {
        return adoptTime;
    }

    public void setAdoptTime(Timestamp adoptTime) {
        this.adoptTime = adoptTime;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "userPhone")
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "userAddress")
    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Basic
    @Column(name = "userGender")
    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adoption adoption = (Adoption) o;

        if (catId != null ? !catId.equals(adoption.catId) : adoption.catId != null) return false;
        if (adoptTime != null ? !adoptTime.equals(adoption.adoptTime) : adoption.adoptTime != null) return false;
        if (userName != null ? !userName.equals(adoption.userName) : adoption.userName != null) return false;
        if (userPhone != null ? !userPhone.equals(adoption.userPhone) : adoption.userPhone != null) return false;
        if (userAddress != null ? !userAddress.equals(adoption.userAddress) : adoption.userAddress != null)
            return false;
        if (userGender != null ? !userGender.equals(adoption.userGender) : adoption.userGender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catId != null ? catId.hashCode() : 0;
        result = 31 * result + (adoptTime != null ? adoptTime.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userAddress != null ? userAddress.hashCode() : 0);
        result = 31 * result + (userGender != null ? userGender.hashCode() : 0);
        return result;
    }

    public Adoption(ApplyToAdopt applyToAdopt) {
        this.catId = applyToAdopt.getCatId();
        this.userAddress = applyToAdopt.getUserAddress();
        this.userGender = applyToAdopt.getUserGender();
        this.userName = applyToAdopt.getUserName();
        this.userPhone = applyToAdopt.getUserPhone();
        this.adoptTime = new Timestamp(System.currentTimeMillis());
    }
}
