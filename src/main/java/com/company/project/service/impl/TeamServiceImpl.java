package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.core.ServiceException;
import com.company.project.dao.TeamMapper;
import com.company.project.dao.UserMapper;
import com.company.project.model.Team;
import com.company.project.model.User;
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

    /**
     * 在team表新增队伍记录
     * @param team
     * @return
     */
    public void addTeam(Team team){
        try {
            teamMapper.insertTeam(team);
        }catch (Exception e){
            throw e;
        }
    };

    /**
     * 在team表更新对应teamID记录的member_left字段
     * @param teamID
     */
    public void addMember(String teamID){
        try {
            Team team=teamMapper.findById(teamID);
            if(team==null){
                throw new ServiceException("队伍不存在");
            }
            int member_left=team.getMember_left();
            member_left-=1;
            team.setMember_left(member_left);
            teamMapper.updateById(team);
        }catch (Exception e){
            throw e;
        }
    };

    /**
     * 在team表更新对应teamID记录的member_left字段
     * @param teamID
     */
    public void removeMember(String teamID){

        try {
            Team team=teamMapper.findById(teamID);
            if(team==null){
                throw new ServiceException("队伍不存在");
            }
            int member_left=team.getMember_left();
            member_left+=1;
            team.setMember_left(member_left);
            teamMapper.updateById(team);
        }catch (Exception e){
            throw e;
        }
    };


}

