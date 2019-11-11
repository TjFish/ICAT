package learning.mapper;

import learning.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author Shidan Cheng
 * @date 3:09 下午 2019/11/11
 */


@Repository
public interface PersonMapper {
    /**
     * [新增人物]
     * @param person [新人物信息]
     * @return [insert语句的返回值]
     */
    public int addPerson(Person person);

    /**
     * [根据人物id删除人物]
     * @param id [人物id, 对应数据库中的id字段]
     */
    public int deletePersonById(Integer id);

    /**
     * [根据人物id查询人物]
     * @param id [人物id, 对应数据库中的id字段]
     * @return [人物信息]
     */
    public Person queryPersonById(Integer id);

    /**
     * [更新人物信息]
     * @param person [新人物信息]
     * @return [update语句的返回值]
     */
    public int updatePerson(Person person);

    /**
     * [查询数据库中的所有的人物信息]
     * @return [人物信息列表]
     */
    public List<Person> queryAllPersons();

}
