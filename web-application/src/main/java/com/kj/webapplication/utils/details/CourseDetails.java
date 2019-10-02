package com.kj.webapplication.utils.details;

import java.util.List;
import java.util.UUID;

public class CourseDetails {
    private UUID id;
    private String title;
    private Integer enrolments;
    private PriceDetails price;
    private List<ModuleDetails> modules;

    protected CourseDetails() {}

    public CourseDetails(UUID id, String title, Integer enrolments, PriceDetails price, List<ModuleDetails> modules) {
        this.id = id;
        this.title = title;
        this.enrolments = enrolments;
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

    public Integer getEnrolments() {
        return enrolments;
    }

    public void setEnrolments(Integer enrolments) {
        this.enrolments = enrolments;
    }

    public PriceDetails getPrice() {
        return price;
    }

    public void setPrice(PriceDetails price) {
        this.price = price;
    }

    public List<ModuleDetails> getModules() {
        return modules;
    }

    public void setModules(List<ModuleDetails> modules) {
        this.modules = modules;
    }
}
