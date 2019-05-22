package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.TeamMapper;
import com.company.project.model.Team;
import com.company.project.service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/05/09.
 */
@Service
@Transactional
public class TeamServiceImpl extends AbstractService<Team> implements TeamService {
    @Resource
    private TeamMapper teamMapper;

    public Team findById(String teamId){return  teamMapper.findById(teamId);}
}
