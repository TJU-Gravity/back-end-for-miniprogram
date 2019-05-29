package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.ApplyMapper;
import com.company.project.model.Apply;
import com.company.project.service.ApplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ApplyServiceImpl extends AbstractService<Apply> implements ApplyService {
    @Resource
    private ApplyMapper applyMapper;

    @Override
    public Apply check(List<String> usernames) {

        return applyMapper.check(usernames);
    }

    @Override
    public void delete(List<String> usernames) {
        applyMapper.deleteByUsernames(usernames);
    }
}
