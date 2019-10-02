package com.kj.webapplication.utils.details;

import java.util.UUID;

public class EnrolmentDetails {
    private UUID id;
    private StudentDetails student;
    private CourseEnrolmentDetails course;

    protected EnrolmentDetails() {}

    public EnrolmentDetails(UUID id, StudentDetails student, CourseEnrolmentDetails course) {
        this.id = id;
        this.student = student;
        this.course = course;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public StudentDetails getStudent() {
        return student;
    }

    public void setStudent(StudentDetails student) {
        this.student = student;
    }

    public CourseEnrolmentDetails getCourse() {
        return course;
    }

    public void setCourse(CourseEnrolmentDetails course) {
        this.course = course;
    }
}
