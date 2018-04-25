package com.sainz.students_and_courses;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CourseRepository extends CrudRepository<Course, Long> {

    ArrayList<Course> findAllByinSession(boolean inSession);

}

