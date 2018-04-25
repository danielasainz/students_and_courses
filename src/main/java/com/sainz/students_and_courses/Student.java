package com.sainz.students_and_courses;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private long id;

    private String studentNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;


    //create a list of courses as one of the variables - will be a set - course is taken by only one student at this point
    //one student takes many courses - variable there defining there is a list of courses (SEE BELOW)
    @OneToMany(mappedBy="oneStudent")
    Set<Course> myCourses;

    public Student(){
        //instantiate courses here - OK, SEE BELOW
        myCourses = new HashSet<>();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Set<Course> getMyCourses() {
        return myCourses;
    }

    public void setMyCourses(Set<Course> myCourses) {
        this.myCourses = myCourses;
    }
}
