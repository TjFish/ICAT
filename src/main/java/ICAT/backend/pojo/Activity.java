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
@Table(name = "activity")
public class Activity {
    @Id
    @Column(name = "activityID")
    private String activityId;

    @Column(name = "adminID")
    private String adminId;
    private String activityName;
    private Timestamp actTime;
    private String actPlace;
    private int partiNum;
    private String activityTitle;
    private String activityDescription;
    private Timestamp publishtime;
    private String activityCover;

    @Transient
    private String coverImageUrl;
    @Transient
    private String adminNikename;

}
