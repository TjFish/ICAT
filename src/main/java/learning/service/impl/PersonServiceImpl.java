package learning.service.impl;

import learning.mapper.PersonMapper;
import learning.pojo.Person;
import learning.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shidan Cheng
 * @date 6:33 下午 2019/11/11
 */
@Service
@CacheConfig(cacheNames = "personCache")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public int addPerson(Person person) {
        return personMapper.addPerson(person);
    }

    @Override
    @CacheEvict(key = "#p0")
    public int deletePersonById(Integer id) {
        return personMapper.deletePersonById(id);
    }

    @Override
    @CacheEvict(key = "#p0.id")
    public int updatePerson(Person person) {
        return personMapper.updatePerson(person);
    }

    @Override
    @Cacheable(key = "#p0", unless = "#result eq null")
    public Person queryPersonById(Integer id) {
        return personMapper.queryPersonById(id);
    }

    @Override
    public List<Person> queryAllPersons() {
        return personMapper.queryAllPersons();
    }
}
