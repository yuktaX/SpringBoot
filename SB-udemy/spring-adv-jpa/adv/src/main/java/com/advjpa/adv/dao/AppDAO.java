package com.advjpa.adv.dao;

import com.advjpa.adv.entity.Instructor;
import com.advjpa.adv.entity.InstructorDetail;

public interface AppDAO {
    
    void save(Instructor theinstructor);

    Instructor findInstructorbyId(int id);

    void deleteInstructor(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetail(int id);
}
