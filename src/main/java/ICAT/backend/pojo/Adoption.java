package ICAT.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: OY
 * @date: 10:17 2019/11/27
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adoption")
public class Adoption {
    @Id
    @Column(name = "catID")
    private String catId;
    private String userAccount;
    private Timestamp adoptTime;
    private String userName;
    private String userPhone;
    private String userAddress;
    private String userGender;
    @Transient
    private String catName;

    public Adoption(ApplyToAdopt applyToAdopt) {
        this.catId = applyToAdopt.getCatId();
        this.userAddress = applyToAdopt.getUserAddress();
        this.userGender = applyToAdopt.getUserGender();
        this.userName = applyToAdopt.getUserName();
        this.userPhone = applyToAdopt.getUserPhone();
        this.adoptTime = new Timestamp(System.currentTimeMillis());
    }
}
