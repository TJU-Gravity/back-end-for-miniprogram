package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.web.model.MyPage;
import com.company.project.model.Post;
import com.company.project.web.model.PostResult;
import com.company.project.web.model.ReplyResult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface PostMapper extends Mapper<Post> {
    List<PostResult> getList(MyPage myPage);
    List<PostResult> getMyList(MyPage myPage);

}