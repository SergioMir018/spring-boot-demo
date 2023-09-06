package com.example.demo.db;

import com.example.demo.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
@AllArgsConstructor
public class PersonDataAccessService implements PersonDB {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insertPerson(UUID id, Person person) {
//        final String sql = "INSERT INTO person (id, name) VALUES (id, person.getName())";
//
//        jdbcTemplate.execute(sql);

        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT id, name FROM person";

        return jdbcTemplate.query(sql,
                (resultSet, i) -> {
                    UUID id = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");

                    return new Person(id, name);
                });
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = ?";

        Person person = jdbcTemplate.queryForObject(
                sql,
                (resultSet, rowNum) -> {
                    UUID personId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");

                    return new Person(personId, name);
                },
                id
        );

        return Optional.ofNullable(person);
    }
}
