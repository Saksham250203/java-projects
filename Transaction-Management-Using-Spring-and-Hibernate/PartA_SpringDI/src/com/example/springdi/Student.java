package com.example.springdi;

public class Student {
    private Course course;

    public Student(Course course) {
        this.course = course;
    }

    public void display() {
        System.out.println("Student enrolled in: " + course.getCourseName());
    }
}
