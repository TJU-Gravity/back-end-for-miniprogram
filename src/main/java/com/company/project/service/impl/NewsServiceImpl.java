package com.company.project.service.impl;

import com.company.project.dao.NewsMapper;
import com.company.project.model.News;
import com.company.project.service.NewsService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/04/21.
 */
@Service
@Transactional
public class NewsServiceImpl extends AbstractService<News> implements NewsService {
    @Resource
    private NewsMapper newsMapper;

}
