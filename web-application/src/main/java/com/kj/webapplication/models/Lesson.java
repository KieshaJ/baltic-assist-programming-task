package com.kj.webapplication.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Lesson extends Audit {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private Integer orderNumber;
    @Column
    private String title;
    @Column
    private String content;

    protected Lesson() {}

    public Lesson(UUID id, Integer order, String title, String content) {
        this.id = id;
        this.orderNumber = order;
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
        return orderNumber;
    }

    public void setOrder(Integer order) {
        this.orderNumber = order;
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
