package ICAT.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author: OY
 * @date: 10:23 2019/11/27
 */
@Table(name = "diseaseRecord")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiseaseRecord {
    @Id
    @Column(name = "recordID")
    private String recordId;
    private String diseaseName;
    private Timestamp startTime;
    private Timestamp endTime;
    private String remark;
    private String catId;

    @Transient
    private String catName;


}
