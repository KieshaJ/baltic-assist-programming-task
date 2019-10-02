package com.kj.webapplication.utils.filters;

import java.util.UUID;

public class EnrolmentFilter extends PagedFilter {
    private UUID studentId;
    private UUID courseId;

    public EnrolmentFilter(Integer page, Integer pageSize, UUID studentId, UUID courseId) {
        super(page, pageSize);
        this.studentId = studentId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }
}
