package backend.dao.repository;

import backend.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shidan Cheng
 * @date 12:59 下午 2019/11/12
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

}