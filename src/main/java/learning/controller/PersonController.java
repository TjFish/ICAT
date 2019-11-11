package learning.controller;

import learning.pojo.Person;
import learning.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shidan Cheng
 * @date 6:53 下午 2019/11/11
 */
@RestController
@RequestMapping(value = "/person", produces = "application/json;charset=utf-8")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@RequestBody Person person) {
        int result = personService.addPerson(person);
        return result >= 1 ? "success" : "error";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePersonById(@PathVariable Integer id) {
        int result = personService.deletePersonById(id);
        return result >= 1 ? "success" : "error";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePerson(@RequestBody Person person) {
        int result = personService.updatePerson(person);
        return result >= 1 ? "success" : "error";
    }

    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public Person queryPersonById(@PathVariable Integer id) {
        return personService.queryPersonById(id);
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Person> queryAllPersons() {
        return personService.queryAllPersons();
    }


}
