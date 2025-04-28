package com.rushcode.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rushcode.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code
    // no need for implementation class
}
