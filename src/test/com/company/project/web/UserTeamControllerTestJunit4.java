package com.company.project.web;

import com.company.project.Application;
import com.company.project.core.Result;
import com.company.project.dao.TeamMapper;
import com.company.project.model.*;
import com.company.project.service.ApplyService;
import com.company.project.service.TeamService;
import com.company.project.service.UserService;
import com.company.project.service.UserTeamService;
import com.company.project.service.impl.TeamServiceImpl;
import com.company.project.service.impl.UserTagsServiceImpl;
import com.company.project.web.model.MyRequestBody;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= Application.class)
public class UserTeamControllerTestJunit4 {

    @Resource
    private UserTeamController controller;
    @Resource
    private TeamMapper teamMapper;


    private  ArrayList<BigDecimal> teamIds=new ArrayList<BigDecimal>();
    private final Logger logger = LoggerFactory.getLogger(UserTeamControllerTestJunit4.class);

    @Test
    public void add() {

        List<Team> teams=teamMapper.getMyList("B");

        for(Team team:teams)
        {
           Result result=controller.add(teamUserFactory("A",team.getTeamid()));
            System.out.print("\n");
           System.out.print(team.getTeam_name());
           System.out.print(result.toString());
        }

    }


    private UserTeam teamUserFactory(String username, BigDecimal teamId)
    {
        UserTeam userTeam=new UserTeam();
        userTeam.setUsername(username);
        userTeam.setTeamid(teamId);


        return userTeam;
    }


}