package com.company.project.service.impl;

import com.company.project.dao.ReplyMapper;
import com.company.project.model.Reply;
import com.company.project.service.ReplyService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/04/21.
 */
@Service
@Transactional
public class ReplyServiceImpl extends AbstractService<Reply> implements ReplyService {
    @Resource
    private ReplyMapper replyMapper;

}
