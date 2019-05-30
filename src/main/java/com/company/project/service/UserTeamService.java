package com.company.project.service;
import com.company.project.model.User;
import com.company.project.model.UserTeam;
import com.company.project.core.Service;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/05/25.
 */
public interface UserTeamService extends Service<UserTeam> {
    List<User> getMembers(BigDecimal teamid);
    void removeUserFromTeam(UserTeam userTeam);
    UserTeam check(BigDecimal teamid,String username);
}
