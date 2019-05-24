package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.Team;
import com.company.project.model.User;


/**
 * Created by CodeGenerator on 2019/05/09.
 */
public interface TeamService extends Service<Team> {
    Team findById(String teamId);
    void addTeam(Team team);
    void addMember(String teamID);
    void removeMember(String teamID);
    //boolean addUser(String teamId, User user);
}
