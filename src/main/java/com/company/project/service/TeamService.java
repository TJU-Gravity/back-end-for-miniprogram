package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.Team;


/**
 * Created by CodeGenerator on 2019/05/09.
 */
public interface TeamService extends Service<Team> {
    Team findById(String teamId);
}
