package com.kj.webapplication.models;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Student extends Audit {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany
    private List<Enrolment> enrolments;

    protected Student() {}

    public Student(UUID id, String name, List<Enrolment> enrolments) {
        this.id = id;
        this.name = name;
        this.enrolments = enrolments;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void setEnrolments(List<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }
}
