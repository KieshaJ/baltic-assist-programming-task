package com.kj.webapplication.controllers;

import com.kj.webapplication.services.StudentService;
import com.kj.webapplication.utils.details.EnrolmentDetails;
import com.kj.webapplication.utils.details.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping(path = "/student")
    public StudentDetails save(@RequestBody StudentDetails details) {
        return service.save(details);
    }

    @GetMapping(path = "/enrol/{studentId}/{courseId}")
    public EnrolmentDetails enrol(@PathVariable UUID studentId, @PathVariable UUID courseId) {
        return service.enrol(studentId, courseId);
    }
}
