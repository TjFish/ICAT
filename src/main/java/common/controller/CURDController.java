package common.controller;


import common.service.CURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @param <E> 实体
 * @param <IDTYPE> 实体主键类型
 * @param <S> 实体Service
 */
public class CURDController<E,IDTYPE,S extends CURDService<E,IDTYPE>> {
    @Autowired
    private S s;

    @GetMapping(value = "/")
    public List<E> getAll() {
        return s.queryAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<E> getById(@PathVariable("id") IDTYPE Id) {
        return s.queryById(Id);
    }

    @PostMapping(value = "/")
    public void add(@RequestBody E e) {
        s.add(e);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") IDTYPE Id) {
        s.deleteById(Id);
    }

    @PutMapping(value = "/")
    public void put(@RequestBody E e) {
        s.update(e);
    }
}
