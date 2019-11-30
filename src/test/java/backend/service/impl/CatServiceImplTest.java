package backend.service.impl;

import backend.pojo.Cat;
import backend.pojo.Image;
import backend.service.CatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CatServiceImplTest {
    @Autowired
    CatServiceImpl catServiceImpl;

    @Test
    public void addCat() {
    }

    @Test
    public void deleteCatById() {
    }

    @Test
    public void updateCat() {
    }

    @Test
    public void queryCatById() {
        System.out.println(catServiceImpl.queryCatById("cat1"));
    }


    @Test
    public void queryAllCat() {
        List<Cat> result = catServiceImpl.queryAllCat();
        result.forEach(System.out::println);
    }

    @Test
    public void existsById() {
        System.out.println(catServiceImpl.existsById("cat1"));
    }

    @Test
    public void getAllImageByCatId(){
        List<Image> result = catServiceImpl.getAllImageByCatId("cat1");
        result.forEach(System.out::println);
    }
}