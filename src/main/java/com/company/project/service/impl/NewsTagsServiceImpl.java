package com.company.project.service.impl;

import com.company.project.dao.NewsTagsMapper;
import com.company.project.model.NewsTags;
import com.company.project.service.NewsTagsService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/04/21.
 */
@Service
@Transactional
public class NewsTagsServiceImpl extends AbstractService<NewsTags> implements NewsTagsService {
    @Resource
    private NewsTagsMapper newstagsMapper;

}
