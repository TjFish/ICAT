package ICAT.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author: OY
 * @date: 10:18 2019/11/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Postcard {
    @Id
    @Column(name = "imageID")
    private String imageId;
    private int produceYear;
    private String producer;
    private String remark;

    @Transient
    private String imageUrl;

}
