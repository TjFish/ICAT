package ICAT.common.service.Impl;


import ICAT.common.exception.ServiceException;
import ICAT.common.service.CURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

/**
 *
 * @param <E> 实体
 * @param <IDTYPE> 实体主键类型
 * @param <R> JpaRepository
 */
public class CURDServiceImpl<E,IDTYPE,R extends JpaRepository<E,IDTYPE>> implements CURDService<E,IDTYPE> {
    @Autowired
    private R r;

    @Override
    public E add(E e) {
        if(r.exists(Example.of(e))) {
            throw new ServiceException(HttpStatus.CONFLICT);
        }
        return r.saveAndFlush(e);
    }

    @Override
    public void deleteById(IDTYPE id) {
        if(!r.existsById(id)) {
            throw new ServiceException(HttpStatus.NOT_FOUND);
        }
        r.deleteById(id);
    }

    @Override
    public void update(E e) {
        r.saveAndFlush(e);
    }

    @Override
    public E queryById(IDTYPE id) {
        Optional<E> e=r.findById(id);
        if (!e.isPresent()) {
            throw new ServiceException(HttpStatus.CONFLICT);
        }
        return e.get();
    }

    @Override
    public List<E> queryAll() {
        return r.findAll();
    }

}
