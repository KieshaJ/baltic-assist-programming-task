package com.kj.webapplication.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Entity
public class Module extends Audit {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private Integer orderNumber;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(min = 1)
    private List<Lesson> lessons;

    protected Module() {
    }

    public Module(UUID id, Integer orderNumber, List<Lesson> lessons) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.lessons = lessons;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}