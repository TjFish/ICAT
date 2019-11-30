package common.service.Impl;


import common.service.CURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

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
    public void add(E e) {
        r.saveAndFlush(e);
    }

    @Override
    public void deleteById(IDTYPE id) {
        r.deleteById(id);
    }

    @Override
    public void update(E e) {
        r.saveAndFlush(e);
    }

    @Override
    public Optional<E> queryById(IDTYPE id) {
        return r.findById(id);
    }

    @Override
    public List<E> queryAll() {
        return r.findAll();
    }
}
