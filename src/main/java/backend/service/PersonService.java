package backend.service;

import backend.pojo.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 6:33 下午 2019/11/11
 */
@Service
public interface PersonService {
    /**
     *  __  __         _             _    _
     * |  \/  | _   _ | |__    __ _ | |_ (_) ___
     * | |\/| || | | || '_ \  / _` || __|| |/ __|
     * | |  | || |_| || |_) || (_| || |_ | |\__ \
     * |_|  |_| \__, ||_.__/  \__,_| \__||_||___/
     *          |___/
     */
    public int addPersonViaMybatis(Person person);

    public int deletePersonByIdViaMyBatis(Integer id);

    public int updatePersonViaMyBatis(Person person);

    public Person queryPersonByIdViaMyBatis(Integer id);

    public List<Person> queryAllPersonsViaMyBatis();


    /**
     *      _  ____    _
     *     | ||  _ \  / \
     *  _  | || |_) |/ _ \
     * | |_| ||  __// ___ \
     *  \___/ |_|  /_/   \_\
     */
    public int addPersonViaJpa(Person person);

    public int deletePersonByIdViaJpa(Integer id);

    public int updatePersonViaJpa(Person person);

    public Optional<Person> queryPersonByIdViaJpa(Integer id);

    public List<Person> queryAllPersonsViaJpa();

}
