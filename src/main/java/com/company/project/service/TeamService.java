package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.Team;
import com.company.project.model.User;


/**
 * Created by CodeGenerator on 2019/05/09.
 */
public interface TeamService extends Service<Team> {
    Team findById(int teamId);
    void addTeam(Team team);
    void addMember(int teamId);
    void removeMember(int teamId);
    //boolean addUser(String teamId, User user);
}
