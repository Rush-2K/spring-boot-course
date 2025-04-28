package com.rushcode.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rushcode.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code
    // no need for implementation class

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
