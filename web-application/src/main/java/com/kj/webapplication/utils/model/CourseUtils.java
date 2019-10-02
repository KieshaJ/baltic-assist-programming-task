package com.kj.webapplication.utils.model;

import com.kj.webapplication.models.Course;
import com.kj.webapplication.utils.details.CourseDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseUtils {
    public static Course toEntity(CourseDetails details) {
        return new Course(details.getId(), details.getTitle(), new ArrayList(), 0, PriceUtils.toEntity(details.getPrice()), ModuleUtils.toEntityList(details.getModules()));
    }

    public static CourseDetails toDetails(Course entity) {
        return new CourseDetails(entity.getId(), entity.getTitle(), entity.getEnrolments().size(), PriceUtils.toDetails(entity.getPrice()), ModuleUtils.toDetailsList(entity.getModules()));
    }

    public static List<Course> toEntityList(List<CourseDetails> detailsList) {
        return detailsList.stream().map(CourseUtils::toEntity).collect(Collectors.toList());
    }

    public static List<CourseDetails> toDetailsList(List<Course> entityList) {
        return entityList.stream().map(CourseUtils::toDetails).collect(Collectors.toList());
    }
}
