package ICAT.common.controller;


import ICAT.common.service.CURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @param <E> 实体
 * @param <IDTYPE> 实体主键类型
 * @param <S> 实体Service
 */
public class CURDController<E, IDTYPE, S extends CURDService<E,IDTYPE>> {

    @Autowired
    private S s;

    @GetMapping(value = "")
    public ResponseEntity<List<E>> getAll() {
        return new ResponseEntity<>(s.queryAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<E> getById(@PathVariable("id") IDTYPE id) {
        return new ResponseEntity<>(s.queryById(id), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<E> add(@RequestBody E e) {
        return new ResponseEntity<>(s.add(e), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") IDTYPE id) {
        s.deleteById(id);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity put(@PathVariable("id") IDTYPE id,@RequestBody E e) {
        s.update(id,e);

        return new ResponseEntity<>("更新成功", HttpStatus.CREATED);

    }
}
