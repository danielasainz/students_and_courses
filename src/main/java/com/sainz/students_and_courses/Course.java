package com.sainz.students_and_courses;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private long id;

    private String courseName;
    private String courseNumber;
    private boolean inSession;

    //Many to One relationship here because multiple courses can be assigned to one student - only that student
    //Have to have Many to One relationship on top of student object

    @ManyToOne()
        Student oneStudent;

    public Course() {
        inSession = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public boolean isInSession() {
        return inSession;
    }

    public void setInSession(boolean inSession) {
        this.inSession = inSession;
    }
    public Student getOneStudent() {
        return oneStudent;
    }

    public void setOneStudent(Student oneStudent) {
        this.oneStudent = oneStudent;
    }

}
