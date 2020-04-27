package com.company.project.service.impl;

import com.company.project.dao.PostMapper;
import com.company.project.service.model.MyRequestBody;
import com.company.project.service.model.PostResult;
import com.company.project.model.Post;
import com.company.project.service.PostService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
@Service
@Transactional
public class PostServiceImpl extends AbstractService<Post> implements PostService {
    @Resource
    private PostMapper postMapper;


    public List<PostResult> getList(MyRequestBody myRequestBody)
    {
        return postMapper.getList();

    }

    @Override
    public List<PostResult> getMyList(MyRequestBody myRequestBody) {

        return postMapper.getMyList(myRequestBody.username);

    }





}
