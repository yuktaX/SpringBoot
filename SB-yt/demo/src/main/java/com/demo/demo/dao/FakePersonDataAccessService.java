package com.demo.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.stereotype.Repository;

import com.demo.demo.model.Person;

@Repository("fake") //instantiate bean, to inject in all classes, give it a name to diffrentiate bw implementations
public class FakePersonDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>(); 

    @Override
    public int insertPerson(UUID id, Person person) {
        // TODO Auto-generated method stubyk
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonbyId(UUID id) {
        return DB.stream()
                    .filter(person -> person.getid().equals(id))
                    .findFirst();
    }

    @Override
    public int deletePersonbyId(UUID id) {
        Optional<Person> personMaybe = selectPersonbyId(id);
        if(personMaybe.isEmpty())
            return 0;
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonbyId(UUID id, Person person_update) {
        return selectPersonbyId(id)
            .map(p -> {
                int indexOfPersonToUpdate = DB.indexOf(p);
                if(indexOfPersonToUpdate >= 0) {
                    DB.set(indexOfPersonToUpdate, new Person(id, person_update.getName()));
                    return 1;
                }
                return 0;
            })
            .orElse(0);

    }
    
}
