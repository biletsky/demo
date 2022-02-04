package org.vbiletsky.springcourse.controller;

import org.springframework.web.bind.annotation.*;
import org.vbiletsky.springcourse.dao.PersonDAO;
import org.vbiletsky.springcourse.model.Person;
import org.vbiletsky.springcourse.service.PersonService;

import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping("/api/v1/customers")
public class PeopleController {

    private final PersonService personService;

    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public Map<String, Set<String>> index() {
        return personService.index();
    }

    @GetMapping("/{name}")
    public Set<String> show(@PathVariable("name") String name) {
        return personService.show(name);
    }

    @PostMapping
    public void create(@ModelAttribute("person") Person person) {
        personService.save(person);
    }

    @PutMapping("/{name}")
    public void update(@ModelAttribute("person") Person person, @PathVariable("name") String name, String phoneNumber) {
        personService.update(name, phoneNumber);
    }

    @DeleteMapping()
    public void delete(@ModelAttribute Person person) {
        personService.delete(person);
    }
}
