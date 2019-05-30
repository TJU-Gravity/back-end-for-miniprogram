package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.Apply;
import com.company.project.model.Team;

import java.math.BigDecimal;
import java.util.List;

public interface ApplyService extends Service<Apply> {
    Apply check(List<String> usernames);
    void delete(List<String> usernames);
    void deleteApplyByTeam(Team team, String username);
}
