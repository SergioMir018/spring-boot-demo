package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@AllArgsConstructor
@RestController
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deletePersonById(@PathVariable("id") UUID id) {
        return personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public int updatePersonById(@PathVariable("id") UUID id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }
}
