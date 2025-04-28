package com.rushcode.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rushcode.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entity manager

    private EntityManager entityManager;

    // set up constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager thEntityManager) {
        entityManager = thEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> thQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = thQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theid) {

        // get employee
        Employee thEmployee = entityManager.find(Employee.class, theid);

        // return employee
        return thEmployee;
    }

    @Override
    public Employee save(Employee thEmployee) {

        // save employee
        Employee dbEmployee = entityManager.merge(thEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int theid) {

        // find employee by id
        Employee thEmployee = entityManager.find(Employee.class, theid);

        // remove employee
        entityManager.remove(thEmployee);
    }

}
