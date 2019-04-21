package com.company.project.service.impl;

import com.company.project.dao.PostMapper;
import com.company.project.model.Post;
import com.company.project.service.PostService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/04/21.
 */
@Service
@Transactional
public class PostServiceImpl extends AbstractService<Post> implements PostService {
    @Resource
    private PostMapper postMapper;

}
