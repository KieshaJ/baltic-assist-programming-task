package com.kj.webapplication.utils.model;

import com.kj.webapplication.models.Student;
import com.kj.webapplication.utils.details.StudentDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentUtils {
    public static Student toEntity(StudentDetails details) {
        return new Student(details.getId(), details.getName(), new ArrayList<>());
    }

    public static StudentDetails toDetails(Student entity) {
        return new StudentDetails(entity.getId(), entity.getName());
    }

    public static List<Student> toEntityList(List<StudentDetails> detailsList) {
        return detailsList.stream().map(StudentUtils::toEntity).collect(Collectors.toList());
    }

    public static List<StudentDetails> toDetailsList(List<Student> entityList) {
        return entityList.stream().map(StudentUtils::toDetails).collect(Collectors.toList());
    }
}
