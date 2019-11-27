package backend.service.impl;

import backend.dao.mapper.PersonMapper;
import backend.dao.repository.PersonRepository;
import backend.pojo.Person;
import backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 6:33 下午 2019/11/11
 */
@Service
@Transactional
@CacheConfig(cacheNames = "personCache")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    /**
     *  __  __         _             _    _
     * |  \/  | _   _ | |__    __ _ | |_ (_) ___
     * | |\/| || | | || '_ \  / _` || __|| |/ __|
     * | |  | || |_| || |_) || (_| || |_ | |\__ \
     * |_|  |_| \__, ||_.__/  \__,_| \__||_||___/
     *          |___/
     */

    @Override
    public int addPersonViaMybatis(Person person) {
        return personMapper.addPerson(person);
    }

    @Override
    @CacheEvict(key = "#p0")
    public int deletePersonByIdViaMyBatis(Integer id) {
        return personMapper.deletePersonById(id);
    }

    @Override
    @CacheEvict(key = "#p0.id")
    public int updatePersonViaMyBatis(Person person) {
        return personMapper.updatePerson(person);
    }

    @Override
    @Cacheable(key = "#p0", unless = "#result eq null")
    public Person queryPersonByIdViaMyBatis(Integer id) {
        return personMapper.queryPersonById(id);
    }

    @Override
    public List<Person> queryAllPersonsViaMyBatis() {
        return personMapper.queryAllPersons();
    }

    /**
     *      _  ____    _
     *     | ||  _ \  / \
     *  _  | || |_) |/ _ \
     * | |_| ||  __// ___ \
     *  \___/ |_|  /_/   \_\
     */

    @Override
    public int addPersonViaJpa(Person person) {
        try {
            personRepository.save(person);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    @CacheEvict(key = "#p0")
    public int deletePersonByIdViaJpa(Integer id) {
        try {
            personRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }

    }

    @Override
    @CacheEvict(key = "#p0.id")
    public int updatePersonViaJpa(Person person) {
        try {
            personRepository.saveAndFlush(person);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    @Cacheable(key = "#p0", unless = "#result eq null")
    public Optional<Person> queryPersonByIdViaJpa(Integer id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> queryAllPersonsViaJpa() {
        return personRepository.findAll();
    }
}
