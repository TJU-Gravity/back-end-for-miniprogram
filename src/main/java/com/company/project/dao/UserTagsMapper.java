package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.UserTags;

import java.util.List;

public interface UserTagsMapper extends Mapper<UserTags> {
    List<UserTags> findAllTags(String username);
}