package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Team;

public interface TeamMapper extends Mapper<Team> {
    Team findById(int teamId);
    void updateById(Team team);
    void insertTeam(Team team);
}