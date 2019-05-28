package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.Team;
import com.company.project.model.User;
import com.company.project.web.model.MyRequestBody;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/05/09.
 */
public interface TeamService extends Service<Team> {


    void addMember(BigDecimal  teamId);
    void removeMember(BigDecimal teamId);
    Team getDetail(BigDecimal teamid);
    void add(Team team);
    List<Team> getMyList(MyRequestBody myRequestBody);
    //boolean addUser(String teamId, User user);
}
