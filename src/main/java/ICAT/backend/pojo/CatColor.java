package ICAT.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author: OY
 * @date: 10:17 2019/11/27
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "catColor")
public class CatColor {
    @Id
    private String colorID;
    private String colorName;
    private String colorDescription;
}
