package com.rush2kcode.cruddemo.dao;

import java.util.List;

import com.rush2kcode.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student thStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findBtLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
