package com.kj.webapplication.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Entity
public class Course extends Audit {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false, unique = true)
    private String title;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Enrolment> enrolments;
    @Column
    private Integer enrolmentCount;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull
    private Price price;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(min = 1)
    private List<Module> modules;

    protected Course() {}

    public Course(UUID id, String title, List<Enrolment> enrolments, Integer enrolmentCount, Price price, List<Module> modules) {
        this.id = id;
        this.title = title;
        this.enrolments = enrolments;
        this.enrolmentCount = enrolmentCount;
        this.price = price;
        this.modules = modules;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void setEnrolments(List<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }

    public Integer getEnrolmentCount() {
        return enrolmentCount;
    }

    public void setEnrolmentCount(Integer enrolmentCount) {
        this.enrolmentCount = enrolmentCount;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
