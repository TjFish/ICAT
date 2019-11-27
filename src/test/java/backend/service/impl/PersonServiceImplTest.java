package backend.service.impl;

import backend.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonServiceImplTest {
    @Autowired
    PersonService personService;

    @Test
    public void queryPersonByIdViaJpa() {
        System.out.println(personService.queryPersonByIdViaJpa(2));
    }
}