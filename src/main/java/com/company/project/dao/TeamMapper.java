package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Team;
import com.company.project.web.model.PostResult;

import java.math.BigDecimal;
import java.util.List;

public interface TeamMapper extends Mapper<Team> {
  void add(Team team);
  List<Team> getMyList(String username);
  Team getDetail(BigDecimal teamid);
}