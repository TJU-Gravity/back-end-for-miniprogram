package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.User;
import com.company.project.model.UserTags;
import com.company.project.service.model.CountTag;

import java.util.List;

public interface UserTagsMapper extends Mapper<UserTags> {
    List<UserTags> findAllTags(String username);
    List<CountTag> findUsersByTags(List<String> tags);
}