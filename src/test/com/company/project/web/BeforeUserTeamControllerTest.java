package com.company.project.web;

import com.company.project.Application;
import com.company.project.core.Result;
import com.company.project.model.*;
import com.company.project.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= Application.class)
public class BeforeUserTeamControllerTest {
    @Test
    public void init()
    {
        initUser("A");
        initUser("B");
        initTeams();
        initApplication();
        initUserTeam();
        initPosts();
        System.out.print("?");
    }


    @Resource
    private PostService postService;
    @Resource
    private TeamService teamService;
    @Resource
    private UserService userService;
    @Resource
    private ApplyService applyService;
    @Resource
    private UserTeamService userTeamService;
    private  int userInit=0;

    private ArrayList<BigDecimal> teamIds=new ArrayList<BigDecimal>();




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
        if(userService.findByUsername(username)!=null)
        {

            userService.deleteByUsername(username);
        }
        User A=userFactory(username);
        userService.save(A);
        userInit++;
    }
    private  void initTeams()
    {
        while (userInit<2)
        {

        }

        for(int i=0;i!=5;i++)
        {

            Team team=teamFactory("team"+i,"B");
            teamService.add(team);
            teamIds.add(team.getTeamid());

        }

    }

    private  void initApplication()
    {

        List<Apply> applications=new ArrayList<>();
        for(int i=1; i!=5 ;i++)
        {
            while( teamIds.get(i)==null)
            {

            }
            applyService.save(applicationFactory("A", teamIds.get(i),"B"));
        }

    }
    private  void initUserTeam()
    {
        while( teamIds.get(1)==null)
        {

        }
        userTeamService.save(teamUserFactory("A",teamIds.get(1)));
        for(int i=0; i!=5 ;i++)
        {
            while( teamIds.get(i)==null)
            {

            }
            userTeamService.save(teamUserFactory("B", teamIds.get(i)));
        }
    }
    private  void initPosts()
    {
        while( teamIds.get(3)==null||teamIds.get(4)==null)
        {

        }

        postService.save(postFactory(teamIds.get(3),BigDecimal.valueOf(0)));
        postService.save(postFactory(teamIds.get(4),BigDecimal.valueOf(1)));

    }



}