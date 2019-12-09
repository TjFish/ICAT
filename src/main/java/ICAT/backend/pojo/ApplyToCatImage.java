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
@Table(name = "applyToCatImage")
public class ApplyToCatImage {
    @Id
    @Column(name = "applicationID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicationId;

    @Column(name = "imageURL")
    private String imageUrl;
    @Column(name = "catID")
    private String catId;
    private Timestamp applicationTime;
    private String auditStatus;
    private String userAccount;

    @Transient
    private String catName;
}
