package crud.demo.dao;

import crud.demo.entity.Student;

public interface StudentDAO {
    
    void save(Student theStudent);
    Student findByid(int id);
}
