package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.UserTeam;
import org.apache.ibatis.annotations.Param;

public interface UserTeamMapper extends Mapper<UserTeam> {
    void insertUserTeam(UserTeam userTeam);
    void deleteUserTeam(@Param("username")  String username,@Param("teamId") int teamId);
}