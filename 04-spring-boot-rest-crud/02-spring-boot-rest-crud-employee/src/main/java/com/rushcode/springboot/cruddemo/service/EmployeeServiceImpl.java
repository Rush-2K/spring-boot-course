package com.rushcode.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushcode.springboot.cruddemo.dao.EmployeeDAO;
import com.rushcode.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO thEmployeeDAO) {
        employeeDAO = thEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theid) {
        return employeeDAO.findById(theid);
    }

    @Transactional
    @Override
    public Employee save(Employee thEmployee) {
        return employeeDAO.save(thEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theid) {
        employeeDAO.deleteById(theid);
    }

}
