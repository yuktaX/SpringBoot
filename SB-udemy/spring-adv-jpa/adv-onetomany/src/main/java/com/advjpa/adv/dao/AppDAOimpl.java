package com.advjpa.adv.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.advjpa.adv.entity.Instructor;
import com.advjpa.adv.entity.InstructorDetail;

import jakarta.persistence.EntityManager;

@Repository
public class AppDAOimpl implements AppDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection

    @Autowired
    public  AppDAOimpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Instructor theinstructor) {
       entityManager.persist(theinstructor);
    }

    @Override
    public Instructor findInstructorbyId(int id) {
       return entityManager.find(Instructor.class, id);
    }

    @Transactional
    @Override
    public void deleteInstructor(int id) {
        Instructor tmp = entityManager.find(Instructor.class, id);

        entityManager.remove(tmp);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {

        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetail(int id) {
        
        InstructorDetail tmp = entityManager.find(InstructorDetail.class, id);

        //to delete: tmp.getInstructor().setInstructorDetail(null)
        entityManager.remove(tmp);
    }
    
    
}
