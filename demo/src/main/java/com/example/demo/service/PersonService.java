package com.example.demo.service;

import com.example.demo.db.PersonDB;
import com.example.demo.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonDB personDB;

    public int addPerson(Person person) {
        return personDB.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDB.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDB.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDB.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person person) {
        return personDB.updatePersonById(id, person);
    }
}
