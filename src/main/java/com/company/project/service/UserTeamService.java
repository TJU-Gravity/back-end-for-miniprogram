package com.company.project.service;
import com.company.project.model.User;
import com.company.project.model.UserTeam;
import com.company.project.core.Service;


/**
 * Created by CodeGenerator on 2019/05/25.
 */
public interface UserTeamService extends Service<UserTeam> {
    void addUserToTeam(User u,int teamId);
    void removeUserFromTeam(String username,int teamId);
}
