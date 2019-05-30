package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.User;
import com.company.project.model.UserTeam;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface UserTeamMapper extends Mapper<UserTeam> {
    UserTeam check(UserTeam userTeam);
    void deleteUserTeam(UserTeam userTeam);
    List<User> getMembers(BigDecimal teamid);
}