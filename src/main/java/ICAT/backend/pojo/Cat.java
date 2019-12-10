package ICAT.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author: OY
 * @date: 20:11 2019/11/27
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cat")

public class Cat {
    @Id
    @Column(name = "CatID")
    private String catId;
    private String catName;
    private String catColor;
    private String catGender;
    private Integer age;
    private String headPortrait;
    private Boolean isSterilization;
    private Boolean isAdopt;
    private Boolean isLost;
    private String hint;
    private String locate;
    private String characteristics;
    private String appearance;

    @Transient
    private String headImageUrl;
    @Transient
    private String colorName;
}
