package learning.service;

import learning.pojo.Person;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shidan Cheng
 * @date 6:33 下午 2019/11/11
 */
@Service
public interface PersonService {
    public int addPerson(Person person);

    public int deletePersonById(Integer id);

    public int updatePerson(Person person);

    public Person queryPersonById(Integer id);

    public List<Person> queryAllPersons();

}
