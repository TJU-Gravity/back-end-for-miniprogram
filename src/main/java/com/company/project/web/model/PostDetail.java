package com.company.project.web.model;

import com.alibaba.fastjson.JSON;
import com.company.project.model.Post;

import com.company.project.model.User;


import java.util.List;

public class PostDetail {
    public Post post;
    public User user;
    public List<ReplyResult> replies;

}
