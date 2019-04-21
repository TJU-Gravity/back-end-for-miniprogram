package com.company.project.service.impl;

import com.company.project.dao.ReplyMapper;
import com.company.project.model.Reply;
import com.company.project.service.ReplyService;
import com.company.project.core.AbstractService;
import com.company.project.web.model.ReplyResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
@Service
@Transactional
public class ReplyServiceImpl extends AbstractService<Reply> implements ReplyService {
    @Resource
    private ReplyMapper replyMapper;
    public List<ReplyResult> getReplys(int postid)
    {
        ArrayList<ReplyResult> list=(ArrayList<ReplyResult>) replyMapper.getReplys(BigDecimal.valueOf(postid));
        if(list==null)
            return new ArrayList<>();
        return list;
    }

}
