package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Reply;
import com.company.project.web.model.ReplyResult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface ReplyMapper extends Mapper<Reply> {
    ArrayList<ReplyResult> getReplys(BigDecimal postid);
}