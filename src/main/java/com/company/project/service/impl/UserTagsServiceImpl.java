package com.company.project.service.impl;

import com.company.project.dao.UserTagsMapper;
import com.company.project.model.UserTags;
import com.company.project.service.UserTagsService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/04/21.
 */
@Service
@Transactional
public class UserTagsServiceImpl extends AbstractService<UserTags> implements UserTagsService {
    @Resource
    private UserTagsMapper usertagsMapper;

}
