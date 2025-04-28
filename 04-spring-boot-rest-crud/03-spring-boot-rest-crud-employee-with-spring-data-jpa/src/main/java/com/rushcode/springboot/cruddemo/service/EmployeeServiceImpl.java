package com.rushcode.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushcode.springboot.cruddemo.dao.EmployeeRepository;
import com.rushcode.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee thEmployee = null;
        if (result.isPresent()) {
            thEmployee = result.get();
        } else {
            // did not find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return thEmployee;
    }

    @Override
    public Employee save(Employee thEmployee) {
        return employeeRepository.save(thEmployee);
    }

    @Override
    public void deleteById(int theid) {
        employeeRepository.deleteById(theid);
    }

}
