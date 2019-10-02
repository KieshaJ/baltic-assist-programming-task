package com.kj.webapplication.utils.details;

import java.util.List;
import java.util.UUID;

public class ModuleDetails {
    private UUID id;
    private Integer order;
    private List<LessonDetails> lessons;

    protected ModuleDetails() {}

    public ModuleDetails(UUID id, Integer order, List<LessonDetails> lessons) {
        this.id = id;
        this.order = order;
        this.lessons = lessons;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<LessonDetails> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonDetails> lessons) {
        this.lessons = lessons;
    }
}
