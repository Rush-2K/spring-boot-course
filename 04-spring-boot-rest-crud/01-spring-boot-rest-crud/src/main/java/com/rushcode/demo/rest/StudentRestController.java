package com.rushcode.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rushcode.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> thStudents;

    // define @PostConstruct to load the student data... only once!

    @PostConstruct
    public void loadData() {

        thStudents = new ArrayList<>();

        thStudents.add(new Student("Cristiano", "Ronaldo"));
        thStudents.add(new Student("Max", "Verstappen"));
        thStudents.add(new Student("Lewis", "Hamilton"));

    }

    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {

        return thStudents;
    }

    // define endpoint or "/students/{studentId}" - return student at index

    @GetMapping("students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // just index into the list ... keep it simple for now

        // check the studentId again list size

        if ( (studentId >= thStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " +studentId);
        }

        return thStudents.get(studentId);
    }

}



