package learning.controller;

import learning.pojo.Person;
import learning.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Shidan Cheng
 * @date 6:53 下午 2019/11/11
 */
@RestController
@RequestMapping(value = "/person", produces = "application/json;charset=utf-8")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/mybatis-add", method = RequestMethod.POST)
    public String addPersonViaMybatis(@RequestBody Person person) {
        int result = personService.addPersonViaMybatis(person);
        return result >= 1 ? "success" : "error";
    }

    @RequestMapping(value = "/mybatis-delete/{id}", method = RequestMethod.GET)
    public String deletePersonByIdViaMybatis(@PathVariable Integer id) {
        int result = personService.deletePersonByIdViaMyBatis(id);
        return result >= 1 ? "success" : "error";
    }

    @RequestMapping(value = "/mybatis-update", method = RequestMethod.POST)
    public String updatePersonViaMybatis(@RequestBody Person person) {
        int result = personService.updatePersonViaMyBatis(person);
        return result >= 1 ? "success" : "error";
    }

    @RequestMapping(value = "/mybatis-query/{id}", method = RequestMethod.GET)
    public Person queryPersonByIdViaMybatis(@PathVariable Integer id) {
        return personService.queryPersonByIdViaMyBatis(id);
    }

    @RequestMapping("/mybatis-all")
    @ResponseBody
    public List<Person> queryAllPersonsViaMybatis() {
        return personService.queryAllPersonsViaMyBatis();
    }


    @RequestMapping(value = "/jpa-add", method = RequestMethod.POST)
    public String addPersonViaJpa(@RequestBody Person person) {
        int result = personService.addPersonViaJpa(person);
        return result >= 1 ? "success" : "error";
    }

    @RequestMapping(value = "/jpa-delete/{id}", method = RequestMethod.GET)
    public String deletePersonByIdViaJpa(@PathVariable Integer id) {
        int result = personService.deletePersonByIdViaJpa(id);
        return result >= 1 ? "success" : "error";
    }

    @RequestMapping(value = "/jpa-update", method = RequestMethod.POST)
    public String updatePersonViaJpa(@RequestBody Person person) {
        int result = personService.updatePersonViaJpa(person);
        return result >= 1 ? "success" : "error";
    }

    @RequestMapping(value = "/jpa-query/{id}", method = RequestMethod.GET)
    public Optional<Person> queryPersonByIdViaJpa(@PathVariable Integer id) {
        return personService.queryPersonByIdViaJpa(id);
    }

    @RequestMapping("/jpa-all")
    @ResponseBody
    public List<Person> queryAllPersonsViaJpa() {
        return personService.queryAllPersonsViaJpa();
    }



}
