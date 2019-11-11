package learning.pojo;

import lombok.Data;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @author Shidan Cheng
 * @date 3:03 下午 2019/11/11
 */

@Data
public class Person implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String position;

    @Override
    public String toString() {
        String info = "ID: {0};\tNAME: {1};\tAGE: {2};\tGENDER: {3}\t;POSITION:{4};";
        return MessageFormat.format(info, id, name, age, gender, position);
    }
}
