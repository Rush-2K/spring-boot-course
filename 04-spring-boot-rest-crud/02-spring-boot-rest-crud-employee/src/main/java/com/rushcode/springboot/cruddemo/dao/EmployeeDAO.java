package com.rushcode.springboot.cruddemo.dao;

import java.util.List;

import com.rushcode.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theid);

    Employee save(Employee thEmployee);

    void deleteById(int theid);
}
