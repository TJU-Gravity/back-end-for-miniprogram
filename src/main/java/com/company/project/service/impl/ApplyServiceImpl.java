package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.ApplyMapper;
import com.company.project.model.Apply;
import com.company.project.service.ApplyService;
import com.company.project.service.model.ApplyList;
import com.company.project.service.model.ApplyResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ApplyServiceImpl extends AbstractService<Apply> implements ApplyService {
    @Resource
    private ApplyMapper applyMapper;



    @Override
    public ApplyList getMyList(String username) {
        List<ApplyResult> list = applyMapper.getMyList(username);
        List<ApplyResult> passed = new ArrayList<>();
        List<ApplyResult> pending = new ArrayList<>();

        for(ApplyResult apply:list){
            if(apply.status==null ||apply.status.equals(1)){
                pending.add(apply);
            }
            else{
                passed.add(apply);
            }
        }

        return new ApplyList(passed,pending);
    }

    @Override
    public Apply check(List<String> usernames) {
        return null;
    }
}
