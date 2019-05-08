package com.company.project.service.impl;

import com.company.project.dao.PostMapper;
import com.company.project.dao.ReplyMapper;
import com.company.project.service.ReplyService;
import com.company.project.web.model.*;
import com.company.project.model.Post;
import com.company.project.service.PostService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
        MyPage myPage=new MyPage();
        myPage.start=(myRequestBody.page-1)*myRequestBody.size;
        myPage.size=myRequestBody.size;
        return postMapper.getList(myPage);

    }

    @Override
    public List<PostResult> getMyList(MyRequestBody myRequestBody) {
        MyPage myPage=new MyPage();
        myPage.start=(myRequestBody.page-1)*myRequestBody.size;
        myPage.size=myRequestBody.size;
        return postMapper.getMyList(myPage);

    }


}
