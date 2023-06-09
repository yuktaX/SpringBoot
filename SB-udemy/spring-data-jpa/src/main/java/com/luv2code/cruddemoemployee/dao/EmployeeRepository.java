package com.luv2code.cruddemoemployee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.cruddemoemployee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
}
