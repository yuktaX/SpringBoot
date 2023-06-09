package com.demo.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.demo.dao.PersonDao;
import com.demo.demo.model.Person;

@Service //or lead component
public class PersonService {

    private final PersonDao personDao;//instantiate the interface

    @Autowired //inject into interface. Using this is dependency injection
    public PersonService(@Qualifier("postgres") PersonDao personDao) //to distinguish implementations
    {
        this.personDao = personDao;
    }

    public int addPerson(Person person)
    {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople()
    {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonbyId(UUID id) 
    {
        return personDao.selectPersonbyId(id);
    }

    public int deletePerson(UUID id)
    {
        return personDao.deletePersonbyId(id);
    }

    public int updatePerson(UUID id, Person newPerson)
    {
        return personDao.updatePersonbyId(id, newPerson);
    }
}
