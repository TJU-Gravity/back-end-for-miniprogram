package com.company.project.service.impl;

import com.company.project.dao.TeamMapper;
import com.company.project.dao.UserTeamMapper;
import com.company.project.model.Team;
import com.company.project.model.User;
import com.company.project.model.UserTeam;
import com.company.project.service.UserTeamService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/05/25.
 */
@Service
@Transactional
public class UserTeamServiceImpl extends AbstractService<UserTeam> implements UserTeamService {
    @Resource
    private UserTeamMapper userTeamMapper;

    @Resource
    private TeamMapper teamMapper;

    public void addUserToTeam(UserTeam userTeam){
        userTeamMapper.insertUserTeam(userTeam);
    };
    public void removeUserFromTeam(String username,int teamId){
        userTeamMapper.deleteUserTeam(username,teamId);
    };
}
