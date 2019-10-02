package com.kj.webapplication.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"student_id", "course_id"})
})
public class Enrolment extends Audit {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @NotNull
    private Student student;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @NotNull
    private Course course;

    protected Enrolment() {}

    public Enrolment(UUID id, Student student, Course course) {
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
