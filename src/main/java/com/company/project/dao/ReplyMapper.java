package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Reply;
import com.company.project.service.model.ReplyResult;


import java.util.ArrayList;

public interface ReplyMapper extends Mapper<Reply> {
    ArrayList<ReplyResult> getReplys(Integer postid);
    ReplyResult getReply(Integer replyid);
}