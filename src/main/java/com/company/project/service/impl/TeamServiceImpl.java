package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.core.ServiceException;
import com.company.project.dao.PostMapper;
import com.company.project.dao.TeamMapper;
import com.company.project.dao.UserMapper;
import com.company.project.dao.UserTeamMapper;
import com.company.project.model.Team;
import com.company.project.model.User;
import com.company.project.service.PostService;
import com.company.project.service.TeamService;
import com.company.project.web.model.MyRequestBody;
import com.company.project.web.model.PostResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/05/09.
 */

@Service
@Transactional
public class TeamServiceImpl extends AbstractService<Team> implements TeamService {
    @Resource
    private TeamMapper teamMapper;
    @Resource
    private UserTeamMapper userTeamMapper;
    @Resource
    private PostMapper postMapper;



    /**
     * 在team表更新对应teamID记录的member_left字段
     * 需确保member_left不是0
     * @param teamId
     */
    public void addMember(BigDecimal teamId){
       try {
           Team team = this.findById(teamId);
           team.setMember_Num(team.getMember_num() + 1);
           this.update(team);
       }
       catch (Exception e)
       {
           throw new ServiceException(e.toString());
       }
    };

    /**
     * 在team表更新对应teamID记录的member_left字段
     * 需确保member_left不等于member_num
     * @param teamId
     */
    public void removeMember(BigDecimal teamId){
        try {
            Team team = this.findById(teamId);
            team.setMember_Num(team.getMember_num() - 1);
            this.update(team);
        }
        catch (Exception e)
        {
            throw new ServiceException(e.toString());
        }

    }

    @Override
    public void add(Team team) {
        teamMapper.add(team);
    }


    @Override
    public Team getDetail(BigDecimal teamid) {
        Team team=this.findById(teamid);
        team.setMembers(userTeamMapper.getMembers(team.getTeamid()));
        team.setPost(postMapper.findPostByTeamID(teamid));
        return team;
    }

    @Override
    public List<Team> getMyList(MyRequestBody myRequestBody) {

        return teamMapper.getMyList(myRequestBody.username);

    }



}

