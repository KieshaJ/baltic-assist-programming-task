package com.kj.webapplication.services;

import com.kj.webapplication.utils.details.EnrolmentDetails;
import com.kj.webapplication.utils.details.StudentDetails;

import java.util.UUID;

public interface StudentService {
    StudentDetails save(StudentDetails details);
    EnrolmentDetails enrol(UUID studentId, UUID courseId);
}
