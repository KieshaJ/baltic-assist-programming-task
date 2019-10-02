package com.kj.webapplication.utils.model;

import com.kj.webapplication.models.Module;
import com.kj.webapplication.utils.details.ModuleDetails;

import java.util.List;
import java.util.stream.Collectors;

public class ModuleUtils {
    public static Module toEntity(ModuleDetails details) {
        return new Module(null, details.getOrder(), LessonUtils.toEntityList(details.getLessons()));
    }

    public static ModuleDetails toDetails(Module entity) {
        return new ModuleDetails(entity.getId(), entity.getOrderNumber(), LessonUtils.toDetailsList(entity.getLessons()));
    }

    public static List<Module> toEntityList(List<ModuleDetails> detailsList) {
        return detailsList.stream().map(ModuleUtils::toEntity).collect(Collectors.toList());
    }

    public static List<ModuleDetails> toDetailsList(List<Module> entityList) {
        return entityList.stream().map(ModuleUtils::toDetails).collect(Collectors.toList());
    }
}
