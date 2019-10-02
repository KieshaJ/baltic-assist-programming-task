package com.kj.webapplication.utils.model;

import com.kj.webapplication.models.Enrolment;
import com.kj.webapplication.utils.details.CourseEnrolmentDetails;
import com.kj.webapplication.utils.details.EnrolmentDetails;

import java.util.List;
import java.util.stream.Collectors;

public class EnrolmentUtils {
    public static Enrolment toEntity(EnrolmentDetails details) {
        return new Enrolment(details.getId(), StudentUtils.toEntity(details.getStudent()), null);
    }

    public static EnrolmentDetails toDetails(Enrolment entity) {
        return new EnrolmentDetails(entity.getId(), StudentUtils.toDetails(entity.getStudent()), new CourseEnrolmentDetails(entity.getCourse().getId(), entity.getCourse().getTitle()));
    }

    public static List<Enrolment> toEntityList(List<EnrolmentDetails> detailsList) {
        return detailsList.stream().map(EnrolmentUtils::toEntity).collect(Collectors.toList());
    }

    public static List<EnrolmentDetails> toDetailsList(List<Enrolment> entityList) {
        return entityList.stream().map(EnrolmentUtils::toDetails).collect(Collectors.toList());
    }
}
