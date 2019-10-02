package com.kj.webapplication.utils.details;

import java.util.UUID;

public class CourseEnrolmentDetails {
    private UUID id;
    private String title;

    protected CourseEnrolmentDetails() {}

    public CourseEnrolmentDetails(UUID id, String title) {
        this.id = id;
        this.title = title;
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
}
