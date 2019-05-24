package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.UserTeam;

public interface UserTeamMapper extends Mapper<UserTeam> {
    void insertUserTeam(UserTeam userTeam);
    void deleteUserTeam(String username,int teamId);
}