package com.kj.webapplication.utils.details;

import java.util.UUID;

public class LessonDetails {
    private UUID id;
    private Integer order;
    private String title;
    private String content;

    protected LessonDetails() {}

    public LessonDetails(UUID id, Integer order, String title, String content) {
        this.id = id;
        this.order = order;
        this.title = title;
        this.content = content;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
