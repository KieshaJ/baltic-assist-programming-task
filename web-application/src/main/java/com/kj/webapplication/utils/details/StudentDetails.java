package com.kj.webapplication.utils.details;

import java.util.UUID;

public class StudentDetails {
    private UUID id;
    private String name;

    protected StudentDetails() {}

    public StudentDetails(UUID id, String name) {
        this.id = id;
        this.name = name;
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
}
