package bjtu.ebookshop.controller;

import bjtu.ebookshop.entity.Person;
import bjtu.ebookshop.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping(value = "/persons")
    public List<Person> persons() {
        return personService.findAll();
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {
        return personService.findOne(id);
    }

    @PostMapping("/save")
    public Person savaPerson(@RequestParam("name") String name,
                             @RequestParam("age") Integer age) {

        Person p = new Person();
        p.setAge(age);
        p.setName(name);
        return personService.insert(p);
    }

    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable("id") Integer id,
                               @RequestParam("name") String name) {
        Person p = new Person();
        p.setId(id);
        p.setName(name);
        return personService.update(p);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable("id") Integer id) {
        personService.delete(id);
    }


}
