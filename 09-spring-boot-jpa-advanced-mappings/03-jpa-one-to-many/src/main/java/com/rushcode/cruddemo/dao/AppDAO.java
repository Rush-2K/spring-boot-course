package com.rushcode.cruddemo.dao;

import java.util.List;

import com.rushcode.cruddemo.entity.Course;
import com.rushcode.cruddemo.entity.Instructor;
import com.rushcode.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);
}
