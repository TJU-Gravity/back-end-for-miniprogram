package com.company.project.web;

import com.company.project.Application;
import com.company.project.core.Result;
import com.company.project.dao.TeamMapper;
import com.company.project.model.*;
import com.company.project.service.*;
import com.company.project.service.impl.TeamServiceImpl;
import com.company.project.service.impl.UserTagsServiceImpl;
import com.company.project.web.model.MyRequestBody;
import org.junit.Assert;
import org.junit.Before;
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
    private TeamService teamService;
    @Resource
    private UserTeamController controller;
    @Resource
    private TeamMapper teamMapper;
    @Resource
    private PostService postService;
    @Resource
    private UserService userService;
    @Resource
    private ApplyService applyService;
    @Resource
    private UserTeamService userTeamService;

    private ArrayList<BigDecimal> teamIds=new ArrayList<BigDecimal>();

    private final Logger logger = LoggerFactory.getLogger(UserTeamControllerTestJunit4.class);

    @Before
    public void init()
    {
        initUser("A");
        initUser("B");

        for(int i=0;i!=4;i++) {
            synchronized (this) {
                teamIds.add(initTeam("team" + i, "B"));
            }
            initApplication("A", teamIds.get(i), "B");
            initUserTeam("B",teamIds.get(i));
        }
        initUserTeam("A",teamIds.get(0));

        initPosts(teamIds.get(2),0);
        initPosts(teamIds.get(3),1);

    }


    @Test
    public void add() {

        List<Team> teams=teamMapper.getMyList("B");

        BigDecimal nonExistentTeamId=teams.get(0).getTeamid().add(BigDecimal.valueOf(5));

        assertNull(teamService.findById(nonExistentTeamId));
        Result result=controller.add(teamUserFactory("A",nonExistentTeamId));

        System.out.print("\n");
        System.out.print("Nonexistent team");
        System.out.print(result.toString());
        System.out.print("\n");

        for(Team team:teams)
        {
            result=controller.add(teamUserFactory("A",team.getTeamid()));
            System.out.print("\n");
            System.out.print(team.getTeam_name());
            System.out.print(result.toString());
            System.out.print("\n");
        }

    }

    private UserTeam teamUserFactory(String username, BigDecimal teamId)
    {
        UserTeam userTeam=new UserTeam();
        userTeam.setUsername(username);
        userTeam.setTeamid(teamId);
        return userTeam;
    }


    private Post postFactory(BigDecimal teamId, BigDecimal state)
    {
        Post post=new Post();
        post.setPostingtime(new Timestamp(new Date().getTime()));
        post.setLastpost(new Timestamp(new Date().getTime()));
        post.setTeamid(teamId);
        post.setState(state);
        post.setPosttype("1");
        post.setPosterid("B");
        post.setTitle("title");
        post.setPostbody("body");
        return post;
    }

    private Apply applicationFactory(String username, BigDecimal teamId, String captainId)
    {
        if (teamId==null) throw new RuntimeException();
        Apply apply=new Apply();
        apply.setTeamid(teamId);
        apply.setCaptainid(captainId);
        apply.setUsername(username);
        return apply;
    }

    private Team teamFactory(String teamName, String captainId)
    {
        Team team=new Team();
        team.setTeam_name(teamName);
        team.setCaptainid(captainId);
        team.setCreate_date(new Date());
        team.setMember_Num(1);
        return team;
    }

    private User userFactory(String username)
    {
        User user=new User();
        user.setUsername(username);
        user.setNickname(username);
        return user;
    }


    private  void initUser(String username)
    {
        synchronized (this) {
            userService.deleteByUsername(username);
        }
        synchronized (this) {
            User A = userFactory(username);
            userService.save(A);
        }
    }

    private BigDecimal initTeam(String teamname,String capainId)
    {
        Team team = teamFactory(teamname, capainId);
        teamService.add(team);
        return team.getTeamid();
    }

    private  void initApplication(String username,BigDecimal teamId,String captainId)
    {
        applyService.save(applicationFactory(username,teamId,captainId));
    }
    private  void initUserTeam(String username,BigDecimal teamId)
    {
        userTeamService.save(teamUserFactory(username,teamId));
    }
    private  void initPosts(BigDecimal teamId,int state)
    {
        postService.save(postFactory(teamId,BigDecimal.valueOf(state)));
    }






}