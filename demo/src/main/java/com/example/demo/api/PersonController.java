package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@AllArgsConstructor
@RestController
@Validated
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<String> addPerson(@RequestBody @NonNull Person person) {
        try {
            personService.addPerson(person);
            return ResponseEntity.status(HttpStatus.CREATED).body(person.toString());
        } catch (BlankFieldException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
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
    public int updatePersonById(@PathVariable("id") UUID id, @NonNull @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }
}
