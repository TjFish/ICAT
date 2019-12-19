package ICAT.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author: OY
 * @date: 10:17 2019/11/27
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applyToAdopt")
public class ApplyToAdopt {
    @Id
    @Column(name = "applicationID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicationId;

    @Column(name = "catID")
    private String catId;
    private String userAccount;
    private Timestamp applicationTime;
    private String reason;
    private String auditStatus;
    private String userName;
    private String userPhone;
    private String userAddress;
    private String userGender;

    @Transient
    private String catName;
}
