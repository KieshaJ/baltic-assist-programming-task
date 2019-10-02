package com.kj.webapplication.utils.model;

import com.kj.webapplication.models.Lesson;
import com.kj.webapplication.utils.details.LessonDetails;

import java.util.List;
import java.util.stream.Collectors;

public class LessonUtils {
    public static Lesson toEntity(LessonDetails details) {
        return new Lesson(details.getId(), details.getOrder(), details.getTitle(), details.getContent());
    }

    public static LessonDetails toDetails(Lesson entity) {
        return new LessonDetails(entity.getId(), entity.getOrder(), entity.getTitle(), entity.getContent());
    }

    public static List<Lesson> toEntityList(List<LessonDetails> detailsList) {
        return detailsList.stream().map(LessonUtils::toEntity).collect(Collectors.toList());
    }

    public static List<LessonDetails> toDetailsList(List<Lesson> entityList) {
        return entityList.stream().map(LessonUtils::toDetails).collect(Collectors.toList());
    }
}
