package com.rushcode.springboot.cruddemo.service;

import java.util.List;

import com.rushcode.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theid);

    Employee save(Employee thEmployee);

    void deleteById(int theid);
}
