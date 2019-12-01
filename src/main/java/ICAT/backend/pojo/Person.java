package ICAT.backend.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @author Shidan Cheng
 * @date 3:03 下午 2019/11/11
 */

@Data
@Entity
@DynamicUpdate
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private String gender;
    private String position;

    @Override
    public String toString() {
        String info = "ID: {0};\tNAME: {1};\tAGE: {2};\tGENDER: {3};\tPOSITION: {4};";
        return MessageFormat.format(info, id, name, age, gender, position);
    }
}
