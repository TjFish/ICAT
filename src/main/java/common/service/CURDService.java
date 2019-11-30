package common.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Licoy
 * @version 2018/5/25/11:43
 * @param <E> 控制器对象实体
 * @param <IDTYPE> 实体主键类型
 */

// 膜拜学长膜拜膜拜膜拜

@Service
public interface CURDService<E,IDTYPE> {

     void add(E one);

     void deleteById(IDTYPE Id);

     void update(E one);

     Optional<E> queryById(IDTYPE Id);

     List<E> queryAll();
}
