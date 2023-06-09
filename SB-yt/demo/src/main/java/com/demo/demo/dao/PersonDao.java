package com.demo.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.demo.demo.model.Person;

public interface PersonDao {
    
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) //id randomly generated
    {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonbyId(UUID id);//obj either is non-nul or null, may or may not exist

    int deletePersonbyId(UUID id);

    int updatePersonbyId(UUID id, Person person);
}
