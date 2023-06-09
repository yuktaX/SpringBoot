package com.demo.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.demo.demo.model.Person;
@Repository("postgres") //another db in postgres, change one line of code, go to qualifier and change
public class PersonDataAccessService implements PersonDao{

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return List.of(new Person (UUID.randomUUID(), "FROM POSTGRES DB"));
    }

    @Override
    public Optional<Person> selectPersonbyId(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonbyId(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonbyId(UUID id, Person person) {
        return 0;
    }
    
}
