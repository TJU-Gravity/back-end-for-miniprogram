package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Team;
import com.company.project.model.UserTeam;
import com.company.project.service.PostService;
import com.company.project.service.TeamService;
import com.company.project.service.UserTagsService;
import com.company.project.service.UserTeamService;
import com.company.project.service.impl.UserTagsServiceImpl;
import com.company.project.web.model.MyRequestBody;
import com.company.project.web.model.PostResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2019/05/09.
*/
@RestController
@RequestMapping("/team")
public class TeamController {
    @Resource
    private TeamService teamService;
    @Resource
    private UserTeamService userTeamService;
    @Resource
    private PostService postService;
    private final Logger logger = LoggerFactory.getLogger(TeamController.class);

    //!
    @PostMapping(value="/add")
    public Result addTeam(@RequestBody Team team) {
        team.setMember_Num(1);
        team.setCreate_date(new Date());
        teamService.add(team);

        UserTeam userTeam=new UserTeam();
        userTeam.setTeamid(team.getTeamid());
        userTeam.setUsername(team.getCaptainid());
        userTeamService.save(userTeam);

        postService.addMember(team.getTeamid(),1);
        return ResultGenerator.genSuccessResult();
    }


//?
    @PostMapping("/detail")
    public Result detail(@RequestBody MyRequestBody body) {
        Team team = teamService.getDetail(body.ID);
        team.setMembers(userTeamService.getMembers(body.ID));
        return ResultGenerator.genSuccessResult(team);
    }



    @PostMapping("/delete")
    public Result delete(@RequestBody MyRequestBody body) {
        teamService.deleteById(body.ID);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Team team) {
        teamService.update(team);
        return ResultGenerator.genSuccessResult();
    }

    //!
    @PostMapping("/myList")
    public Result myList(@RequestBody MyRequestBody myRequestBody) {
        PageHelper.startPage(myRequestBody.page, myRequestBody.size);
        List<Team> list =teamService.getMyList(myRequestBody);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Team> list = teamService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
